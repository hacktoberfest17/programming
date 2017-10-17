package com.example.wellington.pokeapisample.view.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.wellington.pokeapisample.R;
import com.example.wellington.pokeapisample.model.PokemonList;
import com.example.wellington.pokeapisample.model.Result;
import com.example.wellington.pokeapisample.presenter.MainPresenter;
import com.example.wellington.pokeapisample.repository.listener.MainListener;
import com.example.wellington.pokeapisample.view.adapter.PokemonAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.PokemonList)
    RecyclerView pokemonList;
    @Bind(R.id.rlLoading)
    RelativeLayout rlLoading;
    @Bind(R.id.rlSmallLoading)
    RelativeLayout rlSmallLoading;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private PokemonAdapter mAdapter;
    private MainPresenter mainPresenter;
    private LinearLayoutManager mLayoutManager;

    public boolean isFirstLoad = true;
    private int mNextOffset = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter();
        mLayoutManager = new LinearLayoutManager(this);
        pokemonList.setLayoutManager(mLayoutManager);

        setSupportActionBar(toolbar);

        List<Result> list = new ArrayList<>();

        mAdapter = new PokemonAdapter(list, new PokemonAdapter.OnPokemonClickListener() {
            @Override
            public void onPokemonClick(Result pokemonFromList) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(MainPresenter.POKEMON_FROM_LIST, pokemonFromList);
                startActivity(intent);
            }
        });

        pokemonList.setAdapter(mAdapter);

        pokemonList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int visibleItemCount = mLayoutManager.getChildCount();
                if (visibleItemCount == mAdapter.getItemCount()) {
                    getList(mNextOffset);
                }
                return false;
            }
        });

        setOnScrollListener();

        getList(0);
    }

    private void getList(int offSet) {
        mainPresenter.loadPokemonList(offSet, new MainListener() {
            @Override
            public void onPokemonListLoad(PokemonList pokemonList) {

                displayPokemonList(pokemonList);
            }

            @Override
            public void onApiError(Throwable e) {
                apiError(e);
            }

            @Override
            public void onRequestStarted() {
                showLoading();

            }

            @Override
            public void onRequestFinished() {
                hideLoading();
            }

            @Override
            public void onError(Throwable error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void apiError(Throwable e) {
        Toast.makeText(this, "Erro na API", Toast.LENGTH_SHORT).show();
    }


    private void setOnScrollListener() {
        pokemonList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if ((mNextOffset > -1) && (dy > 0)) {
                    int visibleItemCount = mLayoutManager.getChildCount();
                    int totalItemCount = mLayoutManager.getItemCount();
                    int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();

                    if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                        getList(mNextOffset);
                    }
                }
            }
        });

    }

    public void displayPokemonList(PokemonList pokemonList) {

        mAdapter.addAll(pokemonList.results);
        mAdapter.notifyDataSetChanged();

        getNextOffset(pokemonList.next);


    }

    public void getNextOffset(String next) {
        if (next != null && next.length() > 0) {
            String[] array = next.split("offset=");
            mNextOffset = Integer.parseInt(array[array.length - 1]);
        } else {
            mNextOffset = -1;
        }
    }

    public void showLoading() {
        if (isFirstLoad) {
            rlLoading.setVisibility(View.VISIBLE);
        } else {
            rlSmallLoading.setVisibility(View.VISIBLE);
        }
    }

    public void hideLoading() {
        if (isFirstLoad) {
            rlLoading.setVisibility(View.GONE);
            isFirstLoad = false;
        } else {
            rlSmallLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



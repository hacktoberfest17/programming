package com.example.wellington.pokeapisample.view.ui;

import android.support.annotation.AnimatorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wellington.pokeapisample.BuildConfig;
import com.example.wellington.pokeapisample.R;
import com.example.wellington.pokeapisample.model.Species;
import com.example.wellington.pokeapisample.model.Type;
import com.example.wellington.pokeapisample.repository.listener.DetailsListener;
import com.example.wellington.pokeapisample.view.adapter.MyPageAdapter;
import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.presenter.DetailsPresenter;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    public static final String SPICIES = "pokeList";


    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.grid) GridLayout gridView;
    @Bind(R.id.name) TextView name;
    @Bind(R.id.height) TextView height;
    @Bind(R.id.ivSprite) ImageView ivSprite;
    @Bind(R.id.rlLoading) RelativeLayout rlLoading;
    @Bind(R.id.sliding_tabs) TabLayout tabLayout;
    @Bind(R.id.viewpager) ViewPager viewPager;
    @Bind(R.id.species) TextView species;
    @Bind(R.id.fabSpecies) RelativeLayout fabSpecies;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    //  @Bind(R.color.colorPrimaryDark) int colorPrimaryDark;

    private DetailsPresenter mDetailsPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mDetailsPresenter = new DetailsPresenter();
            mDetailsPresenter.loadPokemonDetails(bundle, new DetailsListener() {
                @Override
                public void onLoadDetails(Pokemon pokemon) {
                    setPokemonDetails(pokemon);
                }

                @Override
                public void onLoadSprite(String spriteUML) {
                    setSprites(spriteUML);
                }

                @Override
                public void onApiError(Throwable e) {
                    setSpriteErro();
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
                    Toast.makeText(DetailsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) fabSpecies.getLayoutParams();
        params.height = metrics.heightPixels/2;
        fabSpecies.setLayoutParams(params);

        LinearLayout.LayoutParams gridParams = (LinearLayout.LayoutParams) gridView.getLayoutParams();
        gridParams.height = metrics.heightPixels/2;
        gridView.setLayoutParams(gridParams);

    }

    public void showLoading() {
        rlLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        rlLoading.setVisibility(View.GONE);
    }

    public void setPokemonDetails(Pokemon pokemon) {
        name.setText(pokemon.name);
        height.setText(pokemon.height.toString());

        if(!BuildConfig.IS_BETA){
            setTabs(pokemon);
            setPokemonSpicies(pokemon);
        } else {
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
        }


    }

    public void setTabs(Pokemon pokemon) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setText("Tipo"));
        tabLayout.addTab(tabLayout.newTab().setText("Sprite"));

        MyPageAdapter mpAdapter = new MyPageAdapter(fragmentManager, pokemon);
        viewPager.setAdapter(mpAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }



    public void setSprites(String spriteUML) {
        Picasso.with(this)
                .load(spriteUML)
                .placeholder(R.drawable.egg)
                .error(R.drawable.error_image)
                .into(ivSprite);

    }

    public void setSpriteErro() {
        Picasso.with(this)
                .load(R.drawable.error_image)
                .into(ivSprite);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    private void setPokemonSpicies(Pokemon pokemon) {
        species.setText(pokemon.species.name);

    }


    @OnClick(R.id.fab)
    public void onClickFloating() {



        slideUp();


    }

    public void slideUp() {

        fabSpecies.setVisibility(View.VISIBLE);
        Animation slide_in = AnimationUtils.loadAnimation(this, R.anim.slide_in);
        fabSpecies.startAnimation(slide_in);
        fabSpecies.requestFocus();
        fabSpecies.bringToFront();

    }

    @OnClick(R.id.buttonDown)
    public void onClickDown(){
        slideDown();
    }

    public void slideDown(){

        Animation slide_out = AnimationUtils.loadAnimation(this, R.anim.slide_out);
        slide_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fabSpecies.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fabSpecies.startAnimation(slide_out);
    }


}

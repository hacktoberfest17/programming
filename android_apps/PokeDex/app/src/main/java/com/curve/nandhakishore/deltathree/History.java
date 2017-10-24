package com.curve.nandhakishore.deltathree;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class History extends AppCompatActivity {

    databaseManage dbData = new databaseManage(this);
    RecyclerView history_list;
    RecyclerView.LayoutManager list_manager;
    listAdapter list_adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        dbData.open();
        toolbar = (Toolbar) findViewById(R.id.tBar2);
        setSupportActionBar(toolbar);
        toolbar.setTitle("History");

        history_list = (RecyclerView) findViewById(R.id.history_list);
        list_manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        history_list.setLayoutManager(list_manager);

        list_adapter = new listAdapter(this);
        history_list.setAdapter(list_adapter);
        list_adapter.notifyDataSetChanged();

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        final historyItem temp = PokeUtils.search_history.get(viewHolder.getAdapterPosition());
                        final int pos = viewHolder.getAdapterPosition();
                        PokeUtils.search_history.remove(pos);
                        list_adapter.notifyItemRemoved(pos);
                        dbData.removeRow(temp);
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(history_list);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_clear) {
            PokeUtils.search_history.clear();
            dbData.clearData();
            list_adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        dbData.close();
        super.onDestroy();
    }
}

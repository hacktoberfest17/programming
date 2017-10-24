package com.curve.nandhakishore.deltathree;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.net.URL;

/**
 * Created by Nandha Kishore on 03-07-2017.
 */

public class listAdapter extends RecyclerView.Adapter<listAdapter.cardHolder> {

    static Context myContext;

    public listAdapter(Context con) {
        myContext = con;
    }

    @Override
    public cardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_card, parent, false);
        return new cardHolder(inflatedView);
    }


    @Override
    public void onBindViewHolder(final cardHolder holder, final int position) {

        holder.cName.setText(PokeUtils.search_history.get(PokeUtils.search_history.size()-position-1).name);
        URL url = PokeUtils.search_history.get(PokeUtils.search_history.size()-position-1).image;

        if(url != null)
            Glide.with(myContext).load(url).into(holder.cImage);
        else
            Glide.with(myContext).load(R.drawable.ic_action_name).into(holder.cImage);

    }

    @Override
    public int getItemCount() {
        return PokeUtils.search_history.size();
    }

    public static class cardHolder extends RecyclerView.ViewHolder {

        private ImageView cImage;
        private customTextView cName;

        public cardHolder(View v) {
            super(v);
            this.cImage = (ImageView) v.findViewById(R.id.thumb);
            this.cName = (customTextView) v.findViewById(R.id.h_name);
        }
    }

}
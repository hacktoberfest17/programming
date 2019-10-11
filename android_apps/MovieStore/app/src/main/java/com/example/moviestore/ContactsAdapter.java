package com.example.moviestore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.VH> {
    JSONArray contactList;

    public ContactsAdapter(String cl) {
        try {
            JSONObject jsonObj = new JSONObject(cl);

            this.contactList = jsonObj.getJSONArray("results");
        } catch (Exception e) {
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item, parent, false);
        return new VH(listItem);
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        try {
            JSONObject c = contactList.getJSONObject(position);
            String poster_path = c.getString("poster_path");
            Picasso.get().load("http://image.tmdb.org/t/p/w500" + poster_path).into(holder.poster);


            String adult = c.getString("adult");
            String original_language = c.getString("original_language");
            holder.language.setText(original_language);

            String release_date = c.getString("release_date");
            String year = release_date.substring(0, 4);
            holder.year.setText(year);

            holder.rating.setText(c.getString("vote_average"));
            holder.title.setText(c.getString("title"));

            final String stitle=c.getString("title");
            final String sbackdrop=c.getString("backdrop_path");
            final String spop=c.getString("popularity");
            final String svote=c.getString("vote_average");
           final String srdate=c.getString("release_date");
            final String soverview=c.getString("overview");
           final String slang=c.getString("original_language");
            final String svcount=c.getString("vote_count");
            final String scertitype;

            if (adult.equals("false")) {
                holder.certiType.setText("U");
                scertitype="U";
            } else {
                holder.certiType.setText("A");
                scertitype="A";
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), Information.class);
                    i.putExtra("stitle",stitle);
                    i.putExtra("sbackdrop",sbackdrop);
                    i.putExtra("scertitype",scertitype);
                    i.putExtra("spop",spop);
                    i.putExtra("svote",svote);
                    i.putExtra("soverview",soverview);
                    i.putExtra("srdate",srdate);
                    i.putExtra("slang",slang);
                    i.putExtra("svcount",svcount);
                    view.getContext().startActivity(i);
                }
            });


        } catch (Exception e) {

        }
    }


    @Override
    public int getItemCount() {
        return contactList.length();
    }

    public class VH extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView rating;
        public TextView year;
        public TextView language;
        public ImageView poster;
        public TextView certiType;

        public VH(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.year = itemView.findViewById(R.id.year);
            this.language = itemView.findViewById(R.id.language);
            this.rating = itemView.findViewById(R.id.rating);
            this.poster = itemView.findViewById(R.id.poster);
            this.certiType = itemView.findViewById(R.id.certiType);
        }
    }
}


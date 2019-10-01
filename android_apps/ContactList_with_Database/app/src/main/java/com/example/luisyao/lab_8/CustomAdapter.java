package com.example.luisyao.lab_8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LuisYao on 10/23/17.
 */

public class CustomAdapter extends BaseAdapter{

    Context context;
    List<contact> list_contact;

    public CustomAdapter(Context context,List<contact> list_contact){
        this.context = context;
        this.list_contact = list_contact;
    }

    @Override
    public int getCount() {
        return list_contact.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewholder;

        if (view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.layout_contacto,null);

            viewholder = new ViewHolder();
            viewholder.tv1 = (TextView) view.findViewById(R.id.tv1);
            viewholder.tv2 = (TextView) view.findViewById(R.id.tv2);
            viewholder.tv3 = (TextView) view.findViewById(R.id.tv3);

            view.setTag(viewholder);
        }
        else{
            viewholder = (ViewHolder) view.getTag();
        }

        viewholder.tv1.setText(list_contact.get(i).name);
        viewholder.tv2.setText(list_contact.get(i).email);
        viewholder.tv3.setText(list_contact.get(i).phone);

        return view;
    }

    public void setAdapterData (List <contact> list_contact){
        this.list_contact = list_contact;
    }

    public class ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;

    }
}

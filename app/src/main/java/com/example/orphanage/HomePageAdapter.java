package com.example.orphanage;

import android.content.Context;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomePageAdapter extends BaseAdapter {

    Context context;
    ArrayList<Orphanages> arrayList;

    public HomePageAdapter(Context context,ArrayList<Orphanages>arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.custom_homepage_listview,null);
        TextView t1_name = (TextView)view.findViewById(R.id.tv_display_home_name);
        TextView t2_city = (TextView)view.findViewById(R.id.tv_display_home_city);
        Orphanages orphanages = arrayList.get(i);
        t1_name.setText(orphanages.getOrphanageName());
        t2_city.setText(orphanages.getCity());
        return view;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}

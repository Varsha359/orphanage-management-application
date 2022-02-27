package com.example.orphanage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {
    Context context;
    ArrayList<Messages> arrayList;

    public MessageAdapter(Context context, ArrayList<Messages> arrayList) {
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
        view = inflater.inflate(R.layout.custom_message_listview,null);
        TextView t1_name = (TextView)view.findViewById(R.id.tv_display_m_name);
        TextView t2_city = (TextView)view.findViewById(R.id.tv_display_m_msg);
        Messages messages = arrayList.get(i);
        t1_name.setText(messages.getName()+":");
        t2_city.setText(messages.getMessage());
        return view;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}

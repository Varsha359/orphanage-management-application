

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

public class ViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Orphanages> arrayList;

    public ViewAdapter(Context context,ArrayList<Orphanages>arrayList){
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
        view = inflater.inflate(R.layout.custom_view_listview,null);
        TextView t1_name = (TextView)view.findViewById(R.id.tv_display_orphanage_name);
        TextView t2_mgrname = (TextView)view.findViewById(R.id.tv_display_manager_name);
        TextView t1_address = (TextView)view.findViewById(R.id.tv_display_address);
        TextView t2_accountno = (TextView)view.findViewById(R.id.tv_display_account);
        TextView t1_ifsccode = (TextView)view.findViewById(R.id.tv_display_ifsc);
        TextView t2_email = (TextView)view.findViewById(R.id.tv_display_email);
        TextView t1_phone = (TextView)view.findViewById(R.id.tv_display_phone);
        TextView t2_nooforphanns = (TextView)view.findViewById(R.id.tv_display_no_of_orphans);
        Orphanages orphanages = arrayList.get(i);
        t1_name.setText(orphanages.getOrphanageName());
        t2_mgrname.setText(orphanages.getOrphanageManager());
        t1_address.setText(orphanages.getAddress());
        t2_accountno.setText(orphanages.getAccountNo());
        t1_ifsccode.setText(orphanages.getIFSCCode());
        t2_email.setText(orphanages.getEmail());
        t1_phone.setText(String.valueOf(orphanages.getPhoneNumber()));
        t2_nooforphanns.setText(String.valueOf(orphanages.getOrphansCount()));
        return view;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}

package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    SQLiteDatabase db;
    DBHelper helper;
    ListView l1;
    ArrayList<Orphanages> arrayList;
    ViewAdapter myAdapter;
    String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        helper=new DBHelper(this);
        db=helper.getReadableDatabase();
        l1 = findViewById(R.id.viewList);
        arrayList = new ArrayList<>();


    }

    @Override
    public void onStart(){
        super.onStart();
        loadDataInListView();
    }
    private void loadDataInListView() {

        ArrayList<Orphanages> arrayList = new ArrayList<>();
        Cursor c = db.rawQuery("Select * from OrphanageRegister",null);
        while(c.moveToNext()){
            int id = c.getInt(0);
            String name = c.getString(1);
            String manager = c.getString(2);
            int orphansCount = c.getInt(3);
            String address = c.getString(4);
            String city = c.getString(5);
            String phn = c.getString(6);
            String email = c.getString(7);
            String account = c.getString(8);
            String ifsc = c.getString(9);
            String password = c.getString(10);
            String picturePath = c.getString(11);
            String location = c.getString(12);
            number=phn;
            Orphanages orphanages = new Orphanages(id,name,manager,orphansCount,address,city,phn,email,account,ifsc,password,picturePath,location);
            arrayList.add(orphanages);



        }
        myAdapter = new ViewAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }
    public void call(View v){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91 "+number));
        startActivity(i);
    }
    public void send(View v){
        Intent i = new Intent(getApplicationContext(),sendMessage.class);
        startActivity(i);
    }

}
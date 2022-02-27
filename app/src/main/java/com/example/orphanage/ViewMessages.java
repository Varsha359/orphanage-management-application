package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewMessages extends AppCompatActivity {
    List<String> name;
    List <String> message;
    String NameAr[];
    String MessageAr[];
    ListView l1;
    ArrayList<Messages> arrayList;
    MessageAdapter myAdapter;
    DBHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_messages);
        helper=new DBHelper(this);
        db=helper.getReadableDatabase();
        l1 = findViewById(R.id.msg_listview);
        arrayList = new ArrayList<>();
        ArrayList<Messages> arrayList = new ArrayList<>();
        Cursor c = db.rawQuery("Select * from Messages",null);
        while(c.moveToNext()){
            String name = c.getString(0);
            String msg = c.getString(1);

            Messages messages = new Messages(name,msg);
            arrayList.add(messages);


        }
        myAdapter = new MessageAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}
package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayOrphanage extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    String number;
    TextView orphanagename,managername,noOfOrphans, phone, email, address, account, ifsc;
    Button call,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_orphanage);
        Intent intent = getIntent();
        String name = intent.getStringExtra("orphanageName");
        helper=new DBHelper(this);
        db=helper.getReadableDatabase();
        //String query = "select * from OrphanageRegister where OrphanageName = "+name+";";
        //Cursor c = db.rawQuery(query,null);
        String [] selectionArgs = {name};
        Cursor c = db.query("OrphanageRegister",null,"OrphanageName = ?",selectionArgs,null,null,null);
        call = findViewById(R.id.btn_call);
        message = findViewById(R.id.btn_send_message);
        orphanagename = findViewById(R.id.tv_display_orphanage_name);
        managername = findViewById(R.id.tv_display_manager_name);
        noOfOrphans = findViewById(R.id.tv_display_no_of_orphans);
        phone = findViewById(R.id.tv_display_phone);
        email = findViewById(R.id.tv_display_email);
        address = findViewById(R.id.tv_display_address);
        account = findViewById(R.id.tv_display_address);
        ifsc = findViewById(R.id.tv_display_ifsc);
        if (c.getCount()>0) {
            orphanagename.setText(c.getString(1));
            managername.setText(c.getString(2));
            noOfOrphans.setText(c.getInt(3));
            phone.setText(c.getString(6));
            email.setText(c.getString(7));
            address.setText(c.getString(4));
            account.setText(c.getString(8));
            ifsc.setText(c.getString(9));

            number = c.getString(6);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:91"+number));
                    startActivity(i);
                }
            });
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(),sendMessage.class);
                    startActivity(i);
                }
            });

        }
        else{
            Toast.makeText(getApplicationContext(),"UnRegistered Orphanage",Toast.LENGTH_SHORT).show();
        }


    }
    public void call(View v){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:91"+number));
        startActivity(i);
    }
    public void send(View v){
        Toast.makeText(getApplicationContext(),"trying",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),sendMessage.class);
        startActivity(i);
    }


}
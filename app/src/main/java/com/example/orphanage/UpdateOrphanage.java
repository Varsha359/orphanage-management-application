package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateOrphanage extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    String number;
    EditText orphanagename,managername,noOfOrphans, phone, email, account, ifsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_orphanage);
        orphanagename = findViewById(R.id.et_update_orphanage_name);
        managername = findViewById(R.id.et_update_manager_name);
        noOfOrphans = findViewById(R.id.et_update_no_of_orphans);
        phone = findViewById(R.id.et_update_phone);
        email = findViewById(R.id.et_update_email);
        account = findViewById(R.id.et_update_account);
        ifsc = findViewById(R.id.et_update_ifsc);
        helper=new DBHelper(this);
        db=helper.getWritableDatabase();
    }

    public void update(View v){

        String update_orphanagename = orphanagename.getText().toString();
        String update_manager_name = managername.getText().toString();
        String update_noOfOrphans= noOfOrphans.getText().toString();
        String update_phone = phone.getText().toString();
        String update_email = email.getText().toString();

        String update_ifsc= ifsc.getText().toString();
        String update_account= account.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("OrphanageName", update_orphanagename);
        cv.put("OrphanageManager", update_manager_name);
        cv.put("OrphansCount", update_noOfOrphans);

        cv.put("PhoneNumber", update_phone);
        cv.put("Email", update_email);
        cv.put("AccountNo", update_account);
        cv.put("IFSCcode", update_ifsc);
        String[] selectionArgs = {update_orphanagename};
        long l=db.update("OrphanageRegister",cv,"OrphanageName=?",selectionArgs);
        if(l>0) {
            Toast.makeText(getApplicationContext(), l + "updated", Toast.LENGTH_SHORT).show();
            Log.d("mydebug", "updated");

        Intent i = new Intent(getApplicationContext(),EditAdmin.class);
        startActivity(i);
    }
        else{
            Toast.makeText(getApplicationContext(),"enter orphanage name correctly",Toast.LENGTH_SHORT).show();
        }
}}
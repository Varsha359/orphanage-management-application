package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class sendMessage extends AppCompatActivity {
    EditText name, msg;
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        name = findViewById(R.id.et_name);
        msg = findViewById(R.id.et_send_message);
    }

    public void sendMessage(View v) {

        String sender_name = name.getText().toString();
        String sender_message = msg.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("Name", sender_name);
        cv.put("Message", sender_message);
        long l = db.insert("Messages", null, cv);
        Toast.makeText(getApplicationContext(), l + "Message sent", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), ViewMessages.class);
        startActivity(i);

    }
}
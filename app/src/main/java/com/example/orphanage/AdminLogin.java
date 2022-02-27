package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminLogin extends AppCompatActivity {
    EditText email,pswd;
    DBHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        email=(EditText)findViewById(R.id.et_admin_email);
        pswd=(EditText)findViewById(R.id.et_admin_password);
        helper=new DBHelper(this);
        db=helper.getReadableDatabase();

    }

    public void loginAdmin(View view) {
        String uemail = email.getText().toString();
        String upswd = pswd.getText().toString();
        if(uemail.equals("admin@gmail.com")&& upswd.equals("admin")) {
            Toast.makeText(getApplicationContext(),"Logged in successfully",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),EditAdmin.class);
            startActivity(i);
        }
        else {
            Toast.makeText(getApplicationContext(),"Email or Password does not match",Toast.LENGTH_SHORT).show();
        }

    }
    public void registerUser(View v)
    {
        Intent i=new Intent(getApplicationContext(),Register.class);
        startActivity(i);
    }
}
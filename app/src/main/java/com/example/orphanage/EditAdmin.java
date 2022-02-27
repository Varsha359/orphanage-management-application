package com.example.orphanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin);
    }
    public void view(View v){
        Intent i = new Intent(getApplicationContext(),ViewMessages.class);
        startActivity(i);
    }
    public void update(View v){
        Intent i = new Intent(getApplicationContext(),UpdateOrphanage.class);
        startActivity(i);
    }
    public void registerUser(View v)
    {
        Intent i=new Intent(getApplicationContext(),RegisterAdmin.class);
        startActivity(i);
    }
    public void home(View v){
        Intent i=new Intent(getApplicationContext(),ViewActivity.class);
        startActivity(i);
    }

}
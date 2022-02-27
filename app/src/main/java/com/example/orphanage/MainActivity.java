package com.example.orphanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DBHelper helper;
    SQLiteDatabase db;
    List <String> OrphanageName;
    List <String> City;
    String OrphanageNameAr[];
    String CityAr[];
    ListView l1;
    ArrayList<Orphanages> arrayList;
    HomePageAdapter myAdapter;



    //Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new DBHelper(this);
        db=helper.getReadableDatabase();
        l1 = findViewById(R.id.listview);
        arrayList = new ArrayList<>();


    }

    @Override
    protected void onStart(){
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

            Orphanages orphanages = new Orphanages(id,name,manager,orphansCount,address,city,phn,email,account,ifsc,password,picturePath,location);
            arrayList.add(orphanages);


        }
        myAdapter = new HomePageAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sidemenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Toast.makeText(getApplicationContext(),"login pressed",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(intent);
                return true;
            case R.id.home:
                Toast.makeText(getApplicationContext(),"home pressed",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),ViewActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
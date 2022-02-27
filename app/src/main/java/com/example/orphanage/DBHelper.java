package com.example.orphanage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    Context c;
    public DBHelper(Context c){
        super(c,"AdminDB",null,1);
        this.c=c;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table OrphanageRegister (OrphanageID integer primary key autoincrement,OrphanageName varchar(30), OrphanageManager varchar(20), OrphansCount number(5),Address varchar(75),City varchar(15),PhoneNumber varchar(10),Email varchar(30),AccountNo varchar(20),IFSCcode varchar(10),Password varchar(20),PicturePath varchar(100),Location varchar(300));");
        db.execSQL("create table Messages (Name varchar(30), Message varchar(200));");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        String query,query2;
        query = "drop table if exists OrphanageRegister;";
        db.execSQL(query);
        query2 = "drop table if exists Messages;";
        db.execSQL(query2);

        onCreate(db);


    }

    public ArrayList<Orphanages>getAllData(){
        ArrayList<Orphanages> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
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
        return arrayList;

    }
}
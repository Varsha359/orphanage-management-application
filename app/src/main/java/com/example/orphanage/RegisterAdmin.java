package com.example.orphanage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterAdmin extends AppCompatActivity {
    EditText orphanageName,orphanageMgr,orphansCount,address,city,phone,email,accountNo,ifscCode,password,confirmPassword;
    Button admin_register;
    DBHelper helper;
    SQLiteDatabase db;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);
        orphanageName=(EditText)findViewById(R.id.et_admin_name);

        orphanageMgr=(EditText)findViewById(R.id.et_admin_manager_name);

        orphansCount=(EditText)findViewById(R.id.et_admin_no_of_ppl);

        address=(EditText)findViewById(R.id.et_admin_address);

        city=(EditText)findViewById(R.id.et_admin_city);

        phone=(EditText)findViewById(R.id.et_admin_mobile_no);

        email=(EditText)findViewById(R.id.et_admin_register_email);

        accountNo=(EditText)findViewById(R.id.et_admin_account_no);

        ifscCode=(EditText)findViewById(R.id.et_admin_ifsc_no);

       password=(EditText)findViewById(R.id.et_admin_register_password);

       confirmPassword=(EditText)findViewById(R.id.et_admin_register_confirm_password);

        helper=new DBHelper(this);
        db=helper.getWritableDatabase();
        admin_register=(Button)findViewById(R.id.btn_admin_register_orphanage);

        admin_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String adminName=orphanageName.getText().toString();
                String adminMgrName=orphanageMgr.getText().toString();
                String adminCount=orphansCount.getText().toString();
                String adminAddress=address.getText().toString();
                String adminCity=city.getText().toString();
                String adminPhone=phone.getText().toString();
                String adminEmail=email.getText().toString();
                String adminAccountNo=accountNo.getText().toString();
                String adminIfscCode=ifscCode.getText().toString();
                String adminPassword=password.getText().toString();
                String adminConfirmPassword=confirmPassword.getText().toString();

                if (adminName.length() == 0) orphanageName.setError("Orphanage name is a must");
                else if (adminMgrName.length() == 0) orphanageMgr.setError("Manager name is a must");
                else if (adminCount.length() == 0) orphansCount.setError("Number of orphans is a must");
                else if (adminAddress.length() == 0) address.setError("Address is a must");
                else if (adminCity.length() == 0) city.setError("City name is a must");
                else if (adminPhone.length() == 0) phone.setError("Phone number is a must");
                else if (adminEmail.length() == 0) email.setError("Email ID is a must");
                else if (adminAccountNo.length() == 0) accountNo.setError("Account number is a must");
                else if (adminIfscCode.length() == 0) ifscCode.setError("IFSC Code is a must");
                else if (adminPassword.length() == 0) password.setError("Password is a must");
                else if (adminConfirmPassword.length() == 0 || !(adminPassword.equals(adminConfirmPassword))) confirmPassword.setError("Re-enter the password");
                else flag=1;

                if(flag==1) {
                    ContentValues cv = new ContentValues();
                    cv.put("OrphanageName", adminName);
                    cv.put("OrphanageManager", adminMgrName);
                    cv.put("OrphansCount", adminCount);
                    cv.put("Address", adminAddress);
                    cv.put("City", adminCity);
                    cv.put("PhoneNumber", adminPhone);
                    cv.put("Email", adminEmail);
                    cv.put("AccountNo", adminAccountNo);
                    cv.put("IFSCcode", adminIfscCode);
                    cv.put("Password", adminPassword);
                    long l = db.insert("OrphanageRegister", null, cv);
                    Toast.makeText(getApplicationContext(), l + "Insertion successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), EditAdmin.class);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        orphanageName.setText(" ");
        orphanageMgr.setText(" ");
        orphansCount.setText(" ");
        address.setText(" ");
        city.setText(" ");
        phone.setText(" ");
        email.setText(" ");
        accountNo.setText(" ");
        ifscCode.setText(" ");
        password.setText(" ");
        confirmPassword.setText(" ");
    }
}
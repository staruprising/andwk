package com.example.edate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button bt=(Button)findViewById(R.id.rg);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nm=(EditText)findViewById(R.id.nname);
                EditText pw=(EditText)findViewById(R.id.npw);
                String a=nm.getText().toString();
                String b=pw.getText().toString();
                dbhelper dbh = new dbhelper(register.this, "bwl3.db",null,1);
                SQLiteDatabase db = dbh.getWritableDatabase();
                ContentValues vl = new ContentValues();
                vl.put("name",a);
                vl.put("password",b);
                db.insert("user",null,vl);
                db.close();
                Toast ta=Toast.makeText(register.this,"注册成功",Toast.LENGTH_SHORT);
                ta.show();
                Intent it=new Intent(register.this,Main2Activity.class);
                it.putExtra("unm",a);
                startActivity(it);
            }
        });
    }
}

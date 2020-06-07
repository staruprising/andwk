package com.example.edate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class write extends AppCompatActivity {
    String user="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        Intent it=super.getIntent();
        user=it.getStringExtra("unm");
        Button sav=(Button)findViewById(R.id.save);
        sav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper dbh = new dbhelper(write.this, "bwl3.db",null,1);
                SQLiteDatabase db = dbh.getWritableDatabase();
                EditText wo=(EditText)findViewById(R.id.word);
                String a=wo.getText().toString();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
               int month = calendar.get(Calendar.MONTH)+1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                String b=year+"年"+month+"月"+day+"日";
                ContentValues val = new ContentValues();
                val.put("name",user);
                val.put("date",b);
                val.put("mem",a);
                db.insert("mem",null,val);


                db.close();
                Intent itt=new Intent(write.this,Main2Activity.class);
                itt.putExtra("unm",user);
                startActivity(itt);



            }
        });
    }
}

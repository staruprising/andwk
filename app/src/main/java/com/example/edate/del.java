package com.example.edate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class del extends AppCompatActivity {
String b="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);
        Intent it=super.getIntent();
        String a=it.getStringExtra("body");
        TextView tv=(TextView)findViewById(R.id.tv);
        tv.setText(a);
        b=a;
        Button del=(Button)findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper dbh = new dbhelper(del.this, "bwl3.db",null,1);
                SQLiteDatabase db = dbh.getWritableDatabase();
                String whereClause = "mem=?";
                String[] whereArgs = {b};
                db.delete("mem",whereClause,whereArgs);
                db.close();
            }
        });
    }
}

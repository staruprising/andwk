package com.example.edate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class browse extends AppCompatActivity {
    private String user="";
    private List<mem> memList = new ArrayList<mem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        Intent it=super.getIntent();
        user=it.getStringExtra("unm");
        initbr();
        memadapter adp=new memadapter(browse.this, R.layout.listlo, memList);
        final ListView listView = (ListView) findViewById(R.id.list1);
        listView.setAdapter(adp);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent itn=new Intent(browse.this,del.class);
                mem m2=memList.get(position);
                itn.putExtra("body",m2.getmemo());
                startActivity(itn);

            }
        });
    }
    private void initbr(){

        dbhelper dbh = new dbhelper(browse.this, "bwl3.db",null,1);
        SQLiteDatabase db = dbh.getReadableDatabase();
        Toast t0=Toast.makeText(browse.this,user,Toast.LENGTH_SHORT);

        String select="name=?";
        String[] selectionArgs = { user };
        Cursor cursor = db.query("mem", null,select, selectionArgs, null, null, null);

        if(cursor.moveToFirst()){
            t0.show();
            for(int i=0;i<cursor.getCount();i++){
                cursor.move(i);
                String x=cursor.getString(cursor.getColumnIndex("date"));
                String y=cursor.getString(cursor.getColumnIndex("mem"));

                mem m0=new mem(x,y);
                memList.add(m0);
            }
        }
        cursor.close();
        db.close();
    }
}

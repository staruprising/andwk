package com.example.edate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    String user="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent it=super.getIntent();
        user=it.getStringExtra("unm");
        Button wt=(Button)findViewById(R.id.button2);
        Button br=(Button)findViewById(R.id.button3);
        wt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it1=new Intent(Main2Activity.this,write.class);
                it1.putExtra("unm",user);
                startActivity(it1);
            }
        });
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(Main2Activity.this,browse.class);
                it2.putExtra("unm",user);
                startActivity(it2);
            }
        });
    }
}

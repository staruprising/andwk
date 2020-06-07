package com.example.edate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rg=(Button)findViewById(R.id.reg);
        Button log1=(Button)findViewById(R.id.log);
        Toast toast0 = Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT);
        toast0.show();
        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itt2=new Intent(MainActivity.this,register.class);
                startActivity(itt2);
            }
        });
        log1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper dbh = new dbhelper(MainActivity.this, "bwl3.db",null,1);
                SQLiteDatabase db = dbh.getReadableDatabase();
                EditText nm=(EditText) findViewById(R.id.name);
                EditText psw=(EditText) findViewById(R.id.pw);
                String a=nm.getText().toString();
                String b=psw.getText().toString();
                String select="name=?";
                String[] selectionArgs = { a };
                Cursor cursor = db.query("user", new String[]{"name,password"},select, selectionArgs, null, null, null);
                int i=0;
                Toast toast1 = Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT);

                if(cursor.moveToFirst()){
                    Toast toast2 = Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT);

                    cursor.move(0);
                    String paw=cursor.getString(1);
                    if(b.equals(paw)){i=1;
                        Toast toast3 = Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT);
                        toast3.show();
                        cursor.close();
                        db.close();
                        Intent itt1=new Intent(MainActivity.this,Main2Activity.class);
                        itt1.putExtra("unm",a);
                        startActivity(itt1);

                    }else{
                        Toast toast3 = Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT);
                        toast3.show();
                        cursor.close();
                        db.close();

                    }

                }
                cursor.close();
                db.close();


            }
        });
    }
}

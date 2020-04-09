package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button btn1;
    ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.ETlistentry);
        btn1=(Button)findViewById(R.id.BTN_add);
        lv=(ListView)findViewById(R.id.LV);

        final ArrayList mydata = new ArrayList();

        final ArrayAdapter adapter;
        adapter= new ArrayAdapter(this,R.layout.midlayout,R.id.TV_midlayout,mydata);
        lv.setAdapter(adapter);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = et1.getText().toString();
                mydata.add(s);
                adapter.notifyDataSetChanged();
                et1.setText("");

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                mydata.clear();
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Object obj =  ((ArrayAdapter) lv.getAdapter()).getItem(position);

              String list= obj.toString();

                  Intent intent = new Intent(getApplicationContext(),displaying.class);
                  intent.putExtra("data",list);
                  startActivity(intent);
                  
            }
        });


    }
}

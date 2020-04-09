package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class displaying extends AppCompatActivity {

    TextView tv1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying);
        tv1=(TextView)findViewById(R.id.TV_display);

        Intent i=getIntent();

        String iteams = i.getStringExtra("data");

        tv1.setText(iteams);




    }
}

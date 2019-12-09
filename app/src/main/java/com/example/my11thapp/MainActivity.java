package com.example.my11thapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int initCount;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCount = 0;
        mShowCount = (TextView) findViewById(R.id.text_count);
        Button btn_toast = findViewById(R.id.middle_button);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void Incr(View view) {
        initCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(initCount));
        }
    }

    @SuppressLint("SetTextI18n")
    public void Decr(View view) {
        initCount--;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(initCount));
    }


}

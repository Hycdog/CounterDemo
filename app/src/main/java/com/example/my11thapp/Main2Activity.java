package com.example.my11thapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {



    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getBack() {
        int result = 0;
        Random random = new Random();
        int[] RGB = random.ints(3,0,256).toArray();
        for(int i:RGB){
            result+=i;
            result*=256;
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    public void CreateDiary(View view){
        LinearLayout mHistory = (LinearLayout) findViewById(R.id.layout1);
        TextView newtext = new TextView(this);
        newtext.setHeight(200);
        newtext.setText("abc");
        newtext.setTextSize(12);
        newtext.setBackgroundColor(getBack());
        mHistory.addView(newtext);
        ScrollView scroll = (ScrollView) findViewById(R.id.scroll1);
        scroll.fullScroll(ScrollView.FOCUS_DOWN);
    }

}

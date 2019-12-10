package com.example.my11thapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;
import java.util.zip.Inflater;

public class Main2Activity extends AppCompatActivity {



    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public int getRandomColor() {
        Random random = new Random();
        int[] randomRGB= random.ints(3,0,256).toArray();
        int result = Color.rgb(randomRGB[0],randomRGB[1],randomRGB[2]);
        System.out.println(Integer.toHexString(result));
        return Color.rgb(randomRGB[0],randomRGB[1],randomRGB[2]);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    public void CreateDiary(View view){
        LinearLayout mHistory = (LinearLayout) findViewById(R.id.layout1);
        LayoutInflater inflater = this.getLayoutInflater();
        LinearLayout newdiary = (LinearLayout) inflater.inflate(R.layout.diary,null);
        newdiary.setBackgroundColor(getRandomColor());
        mHistory.addView(newdiary,0);
        ScrollView scroll = (ScrollView) findViewById(R.id.scroll1);
        scroll.fullScroll(ScrollView.FOCUS_UP);
    }

}

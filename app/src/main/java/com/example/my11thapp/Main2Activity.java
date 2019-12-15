package com.example.my11thapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.zip.Inflater;

public class Main2Activity extends AppCompatActivity {



    TextInputEditText textInputEditText;
    LinearLayout mHistory;
    LinearLayout newHistory;
    String textBuffer;
    TextView textView;
    Button butt;

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
        return Color.rgb(randomRGB[0],randomRGB[1],randomRGB[2]);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    public void CreateDiary(View view){

        butt = findViewById(R.id.button_add);
        butt.setEnabled(false);

        mHistory = findViewById(R.id.layout1);
        LayoutInflater inflater = this.getLayoutInflater();
        LinearLayout newdiary = (LinearLayout) inflater.inflate(R.layout.diary,null);

        int color = getRandomColor();
        newdiary.setBackgroundColor(color);
        Button button = newdiary.findViewById(R.id.submit);
        textInputEditText = newdiary.findViewById(R.id.text_input);
        boolean light = 0.213 * Color.red(color) +
                0.715 * Color.green(color) +
                0.072 * Color.blue(color) > 127;

        textInputEditText.setTextColor(light?Color.BLACK:Color.WHITE);


        newHistory = (LinearLayout) inflater.inflate(R.layout.history,null);
        newHistory.setBackgroundColor(color);
        textView = newHistory.findViewById(R.id.text_v);
        textView.setTextColor(light?Color.BLACK:Color.WHITE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime localDateTime = LocalDateTime.now();
            textInputEditText.setHint(localDateTime.toString());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View vm = mHistory.getChildAt(0);
                textBuffer = ((TextInputEditText)(vm.findViewById(R.id.text_input))).getText().toString();
                mHistory.removeView(vm);
                System.out.println(textBuffer);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    LocalDateTime localDateTime = LocalDateTime.now();
                    textView.setText(localDateTime.toString()+"\n"+textBuffer);
                }
                else{
                    textView.setText(textBuffer);
                }
                mHistory.addView(newHistory,0);
                butt.setEnabled(true);
            }
        });

        mHistory.addView(newdiary,0);
        ScrollView scroll = findViewById(R.id.scroll1);
        scroll.fullScroll(ScrollView.FOCUS_UP);
    }



}

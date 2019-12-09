package com.example.my11thapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private int initCount;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCount = 0;
        mShowCount = (TextView) findViewById(R.id.HelloStr);
    }

    public void ShowToast(View view) {
        Toast toast = Toast.makeText(this, R.string.str_toast,
                Toast.LENGTH_SHORT);
        toast.show();
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

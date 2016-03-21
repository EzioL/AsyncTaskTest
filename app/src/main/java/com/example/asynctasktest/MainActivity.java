package com.example.asynctasktest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAsyncTask task = new MyAsyncTask();
        task.execute();
    }

    public void loadProgressBar(View v) {
        startActivity(new Intent(MainActivity.this, ProgressBarTest.class));
    }

    public void loadImage(View v) {
        startActivity(new Intent(MainActivity.this, ImageTest.class));
    }
}

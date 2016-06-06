package com.mingying.androidmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mingying.androidmanager.managers.MyActivityManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyActivityManager.getRunningPro(this);


    }
}

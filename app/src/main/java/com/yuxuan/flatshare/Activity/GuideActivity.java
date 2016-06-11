package com.yuxuan.flatshare.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuxuan.flatshare.R;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_guide);
    }
}

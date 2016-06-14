package com.yuxuan.flatshare.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuxuan.flatshare.R;
import com.yuxuan.flatshare.Utils.ConfigUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        //设置为第一次运行
        ConfigUtils.setIsRun(this);
    }
}

package com.yuxuan.flatshare.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.yuxuan.flatshare.R;
import com.yuxuan.flatshare.Utils.ConfigUtils;

public class SplashActivity extends AppCompatActivity {

    private ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_splash);

        //dddddddddddddddddddd

        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        //自定义透明动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);
        //给图片设置透明动画
        ivSplash.setAnimation(alphaAnimation);

        //2秒后才跳转下一个页面
        new Thread(new Runnable() {
            @Override
            public void run() {
                //暂停2秒
                SystemClock.sleep(2000);

                Intent intent = new Intent();
                //判断第几次使用
                if (ConfigUtils.getIsRun(SplashActivity.this)) {
                    //第一次使用APP
                    intent.setClass(SplashActivity.this, GuideActivity.class);
                } else {
                    //已经使用过APP
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }
                //跳转页面并关闭当前页面
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }).start();
    }
}

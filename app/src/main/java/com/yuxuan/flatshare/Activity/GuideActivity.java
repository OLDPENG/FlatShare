package com.yuxuan.flatshare.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.yuxuan.flatshare.R;

public class GuideActivity extends AppCompatActivity {

    //V
    private Button btGuide;
    private RadioGroup rgGuide;
    private ViewPager vpGuide;

    //M
    private int[] images = new int[]{
            R.mipmap.guide_pic_1,
            R.mipmap.guide_pic_2,
            R.mipmap.guide_pic_3,
            R.mipmap.guide_pic_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEnvent();
    }

    private void initEnvent() {
        //ViewPage 的滑动事件
        vpGuide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            //position 被选中的图片下标
            public void onPageSelected(int position) {
                if (position == 0) {
                    rgGuide.check(R.id.rbGuide1);
                    btGuide.setVisibility(View.GONE);
                }
                if (position == 1) {
                    rgGuide.check(R.id.rbGuide2);
                    btGuide.setVisibility(View.GONE);
                }
                if (position == 2) {
                    rgGuide.check(R.id.rbGuide3);
                    btGuide.setVisibility(View.GONE);
                }
                if (position == 3) {
                    rgGuide.check(R.id.rbGuide4);
                    btGuide.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //rbGuide 点击事件
        rgGuide.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbGuide1:
                        vpGuide.setCurrentItem(0);
                        break;
                    case R.id.rbGuide2:
                        vpGuide.setCurrentItem(1);
                        break;
                    case R.id.rbGuide3:
                        vpGuide.setCurrentItem(2);
                        break;
                    case R.id.rbGuide4:
                        vpGuide.setCurrentItem(3);
                        break;
                }
            }
        });

        //btGuide 点击事件
        btGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GuideActivity.this, MainActivity.class);
                //跳转页面并关闭当前页面
                GuideActivity.this.startActivity(intent);
                GuideActivity.this.finish();
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_guide);

        btGuide = (Button) findViewById(R.id.btGuide);
        rgGuide = (RadioGroup) findViewById(R.id.rgGuide);
        vpGuide = (ViewPager) findViewById(R.id.vpGuide);

        vpGuide.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            //为 Viewpage 加一个页面
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(GuideActivity.this);
                imageView.setBackgroundResource(images[position]);
                container.addView(imageView);
                return imageView;
            }

            @Override
            //为 Viewpage 销毁个页面
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }
}

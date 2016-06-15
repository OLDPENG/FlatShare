package com.yuxuan.flatshare.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yuxuan.flatshare.Fragment.AddFragment;
import com.yuxuan.flatshare.Fragment.HomeFragment;
import com.yuxuan.flatshare.Fragment.MessageFragment;
import com.yuxuan.flatshare.Fragment.OneselfFragment;
import com.yuxuan.flatshare.Fragment.SearchFragment;
import com.yuxuan.flatshare.R;
import com.yuxuan.flatshare.Utils.ConfigUtils;

public class MainActivity extends FragmentActivity {

    //该窗体的碎片管理器
    private FragmentManager fragmentManager;
    private RadioGroup rgMenu;
    private RadioButton rbMenu3;
    private TextView tvTitle;

    private Fragment[] fragments = new Fragment[]{
            new HomeFragment(),
            new SearchFragment(),
            new AddFragment(),
            new MessageFragment(),
            new OneselfFragment()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEnvent();
    }

    private void initEnvent() {
        rgMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment = null;
                switch (checkedId) {
                    case R.id.rbMenu1:
                        fragment = fragments[0];
                        Submit(fragment);
                        break;
                    case R.id.rbMenu2:
                        fragment = fragments[1];
                        Submit(fragment);
                        break;
                    case R.id.rbMenu4:
                        fragment = fragments[3];
                        Submit(fragment);
                        break;
                    case R.id.rbMenu5:
                        fragment = fragments[4];
                        Submit(fragment);
                        break;
                }
            }

            private void Submit(Fragment fragment) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frmMain, fragment, "main");
                transaction.commit();
            }
        });

        rbMenu3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddActivity.class);
                startActivity(intent);
                //设置选中状态为假,要不然下次点击会没效果
                rbMenu3.setChecked(false);
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        //设置为第一次运行
        ConfigUtils.setIsRun(this);

        fragmentManager = getSupportFragmentManager();
        rgMenu = (RadioGroup) findViewById(R.id.rgMenu);

        //设置首页碎片
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frmMain, fragments[0], "home");
        transaction.commit();

        rbMenu3 = (RadioButton) findViewById(R.id.rbMenu3);
    }
}

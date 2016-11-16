package com.cys.test.bannerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;

import com.cys.test.bannerdemo.view.BannerLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private BannerLayout bannerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 如果图片地址失效请替换可以访问的图片地址
        List<String> urls = new ArrayList<>();
        urls.add("http://imgsrc.baidu.com/forum/pic/item/b58f8c5494eef01f52c90041e0fe9925bd317d50.jpg");
        urls.add("http://imgsrc.baidu.com/forum/w=580/sign=33abe21e96529822053339cbe7cb7b3b/157d352ac65c103826cb101bb4119313b17e8964.jpg");
        urls.add("http://imgsrc.baidu.com/forum/w%3D580/sign=37d3bf8730adcbef01347e0e9cae2e0e/2df5e0fe9925bc31bb1187db5fdf8db1cb137021.jpg");
        urls.add("");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(screenWidth, screenWidth);
        bannerLayout = (BannerLayout) findViewById(R.id.banner_layout);
//        bannerLayout.setLayoutParams(params); // 设置高度=宽度=屏幕宽度
        bannerLayout.setViewUrls(urls);
        bannerLayout.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d(TAG, "onItemClick: position=" + position);
            }
        });
    }
}

package com.ad.admanagerdemo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.ad.ad_manager.AD_Manager;
import com.ad.ad_manager.callback.PopCallAdShow;
import com.ad.ad_manager.callback.SplashCallAdShow;
import com.ad.ad_manager.callback.VideoCallAdShow;
import com.ad.ad_manager.constant.AD_Type;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button splash, pop, video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash = findViewById(R.id.splash);
        pop = findViewById(R.id.pop);
        video = findViewById(R.id.video);

        splash.setOnClickListener(this);
        pop.setOnClickListener(this);
        video.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.splash:

                    AD_Manager.get().getSplashAD(MainActivity.this, new SplashCallAdShow() {
                        @Override
                        public void onAdClose(long time, AD_Type adType) {
                            //广告关闭
                            ((FrameLayout) findViewById(R.id.ad_show)).removeAllViews();
                        }

                        @Override
                        public void onAdStartRequest(long startTime, AD_Type adType) {
                            //开始请求
                        }

                        @Override
                        public void onAdFailed(long endTime, String failedMsg, AD_Type adType) {
                            //请求失败
                        }

                        @Override
                        public void onAdLoaded(long time, AD_Type adType) {
                            ((FrameLayout) findViewById(R.id.ad_show)).removeAllViews();
                            ((FrameLayout) findViewById(R.id.ad_show)).addView(adType.getContainerView());
                        }

                        @Override
                        public void onAdClicked(long time, AD_Type adType) {
                            Toast.makeText(MainActivity.this, "点击了广告", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAdExpose(long time, AD_Type adType) {

                        }
                    });

                    break;
                case R.id.pop:
                    AD_Manager.get().getPopAD(MainActivity.this, new PopCallAdShow() {

                        @Override
                        public void onAdStartRequest(long startTime, AD_Type adType) {

                        }

                        @Override
                        public void onAdFailed(long endTime, String failedMsg, AD_Type adType) {

                        }

                        @Override
                        public void onAdLoaded(long time, AD_Type adType) {
                            ((FrameLayout) findViewById(R.id.ad_show)).removeAllViews();
                            ((FrameLayout) findViewById(R.id.ad_show)).addView(adType.getContainerView());
                        }

                        @Override
                        public void onAdClicked(long time, AD_Type adType) {
                            Toast.makeText(MainActivity.this, "点击了广告", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAdExpose(long time, AD_Type adType) {

                        }
                    });
                    break;
                case R.id.video:
                    AD_Manager.get().getVideoAD(MainActivity.this, new VideoCallAdShow() {

                        @Override
                        public void onAdClose(long time, AD_Type adType) {

                        }

                        @Override
                        public void onAdFinish(long time, AD_Type adType) {

                        }

                        @Override
                        public void onAdStartRequest(long startTime, AD_Type adType) {

                        }

                        @Override
                        public void onAdFailed(long endTime, String failedMsg, AD_Type adType) {

                        }

                        @Override
                        public void onAdLoaded(long time, AD_Type adType) {
                            Log.e("Nothing", "onAdLoaded");
                            adType.showVideo(findViewById(R.id.ad_show));
                        }

                        @Override
                        public void onAdClicked(long time, AD_Type adType) {
                            Toast.makeText(MainActivity.this, "点击了广告", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onAdExpose(long time, AD_Type adType) {
                            Toast.makeText(MainActivity.this, "激励有效", Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;

                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
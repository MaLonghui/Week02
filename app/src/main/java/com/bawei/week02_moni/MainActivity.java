package com.bawei.week02_moni;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView img_view;
    private RelativeLayout linear;
    private int width;
    private int height;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        img_view = findViewById(R.id.img_view);
        //设置动画
        lineAnimator();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

    private void lineAnimator() {
        //平移
        ObjectAnimator translationY = ObjectAnimator.ofFloat(img_view, "translationY", img_view.getTranslationY(), 400);
        //旋转
        ObjectAnimator rotation = ObjectAnimator.ofFloat(img_view,"rotation",0,360);
        //渐变
        ObjectAnimator alpha = ObjectAnimator.ofFloat(img_view,"alpha",0,1,0,1);
        //缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(img_view, "scaleX", 0, 1);

        animatorSet = new AnimatorSet();
        animatorSet.play(translationY).with(rotation).with(alpha).with(scaleX);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }
}

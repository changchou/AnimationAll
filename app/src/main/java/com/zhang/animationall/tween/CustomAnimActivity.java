package com.zhang.animationall.tween;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.zhang.animationall.R;

public class CustomAnimActivity extends AppCompatActivity {

    private ImageView example;
    private ImageView ball;
    private Button t3d1, t3d2, skew, pao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_anim);

        initView();
    }

    private void initView() {
        example = (ImageView) findViewById(R.id.example);
        ball = (ImageView) findViewById(R.id.ball);
        t3d1 = (Button) findViewById(R.id.t3d1);
        t3d2 = (Button) findViewById(R.id.t3d2);
        skew = (Button) findViewById(R.id.skew);
        pao = (Button) findViewById(R.id.pao);

        t3d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example.setVisibility(View.VISIBLE);
                ball.setVisibility(View.GONE);
                Animation animation = new ThreeDRotateAnimation(0, 360, v.getWidth() / 2, v.getHeight() / 2, v.getWidth() / 2, 0);
                animation.setDuration(3000);
                example.startAnimation(animation);
                v.startAnimation(animation);
            }
        });
        t3d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example.setVisibility(View.VISIBLE);
                ball.setVisibility(View.GONE);
                Animation animation = new ThreeDRotateAnimation(0, 360, v.getWidth() / 2, v.getHeight() / 2, v.getWidth() / 2, 1);
                animation.setDuration(3000);
                example.startAnimation(animation);
                v.startAnimation(animation);
            }
        });
        skew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example.setVisibility(View.VISIBLE);
                ball.setVisibility(View.GONE);
                Animation animation = new SkewAnimation(0.5f, 0.5f);
                animation.setDuration(3000);
                example.startAnimation(animation);
                v.startAnimation(animation);
            }
        });
        pao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example.setVisibility(View.GONE);
                ball.setVisibility(View.VISIBLE);
                Animation animation = new PaoAnimation(v.getWidth());
                animation.setDuration(3000);
                ball.startAnimation(animation);
            }
        });
    }
}

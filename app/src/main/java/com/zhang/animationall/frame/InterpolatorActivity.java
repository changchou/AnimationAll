package com.zhang.animationall.frame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.zhang.animationall.R;

public class InterpolatorActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ball;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);

        ball = (ImageView) findViewById(R.id.ball);
        findViewById(R.id.interp1).setOnClickListener(this);
        findViewById(R.id.interp2).setOnClickListener(this);
        findViewById(R.id.interp3).setOnClickListener(this);
        findViewById(R.id.interp4).setOnClickListener(this);
        findViewById(R.id.interp5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ball.setVisibility(View.GONE);
        switch (v.getId()) {
            case R.id.interp1:
                animation = AnimationUtils.loadAnimation(this, R.anim.translate2);
                animation.setInterpolator(new AccelerateInterpolator());
                break;
            case R.id.interp2:
                animation = new TranslateAnimation(0, 300, 0, 0);
                animation.setInterpolator(new BounceInterpolator());
                break;
            case R.id.interp3:
                animation = new TranslateAnimation(0, 300, 0, 0);
                animation.setInterpolator(new AnticipateOvershootInterpolator());
                break;
            case R.id.interp4:
                animation = AnimationUtils.loadAnimation(this, R.anim.translate2);
                break;
            case R.id.interp5:
                animation = new TranslateAnimation(0, 0, 0, -300);
                animation.setInterpolator(new GravityInterpolator());
                break;
        }
        ball.setVisibility(View.VISIBLE);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        ball.startAnimation(animation);
    }
}

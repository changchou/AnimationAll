package com.zhang.animationall.frame;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.zhang.animationall.R;

public class ViewAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView example;
    private AnimationDrawable frameAnim;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);

        example = (ImageView) findViewById(R.id.example);
        findViewById(R.id.anim1).setOnClickListener(this);
        findViewById(R.id.anim2).setOnClickListener(this);
        findViewById(R.id.anim3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        example.setVisibility(View.GONE);
        example.setVisibility(View.VISIBLE);
        switch (v.getId()) {
            case R.id.anim1:
                example.setBackgroundResource(R.drawable.walk);
                frameAnim = (AnimationDrawable) example.getBackground();
                animation = new TranslateAnimation(-300, 300, 0, 0);
                animation.setDuration(8000);
                animation.setFillAfter(true);
                animation.setInterpolator(new LinearInterpolator());
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (frameAnim != null && !frameAnim.isRunning()) {
                            frameAnim.stop();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                frameAnim.start();
                example.startAnimation(animation);
                break;
            case R.id.anim2:
                example.setBackgroundResource(R.drawable.running);
                frameAnim = (AnimationDrawable) example.getBackground();
                animation = new TranslateAnimation(-300, 100, 0, 0);
                animation.setDuration(3000);
                animation.setFillAfter(true);
                animation.setInterpolator(new LinearInterpolator());
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (frameAnim != null && !frameAnim.isRunning()) {
                            frameAnim.stop();
                        }
                        example.setBackgroundResource(R.drawable.jump);
                        frameAnim = (AnimationDrawable) example.getBackground();
                        Animation a = new TranslateAnimation(100, 200, 0, 0);
                        a.setDuration(850);
                        a.setFillAfter(true);
                        a.setInterpolator(new LinearInterpolator());
                        a.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                if (frameAnim != null && !frameAnim.isRunning()) {
                                    frameAnim.stop();
                                }
                                example.setBackgroundResource(R.drawable.running);
                                frameAnim = (AnimationDrawable) example.getBackground();
                                Animation a = new TranslateAnimation(200, 300, 0, 0);
                                a.setDuration(900);
                                a.setFillAfter(true);
                                a.setInterpolator(new LinearInterpolator());
                                a.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                        if (frameAnim != null && !frameAnim.isRunning()) {
                                            frameAnim.stop();
                                        }
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
                                });
                                frameAnim.start();
                                example.startAnimation(a);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        frameAnim.start();
                        example.startAnimation(a);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                frameAnim.start();
                example.startAnimation(animation);
                break;
            case R.id.anim3:
                example.setBackgroundResource(R.drawable.running);
                frameAnim = (AnimationDrawable) example.getBackground();
                animation = new TranslateAnimation(-300, 300, 0, 0);
                animation.setDuration(4000);
                animation.setFillAfter(true);
                animation.setInterpolator(new LinearInterpolator());
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (frameAnim != null && !frameAnim.isRunning()) {
                            frameAnim.stop();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                frameAnim.start();
                example.startAnimation(animation);
                break;
        }
    }
}

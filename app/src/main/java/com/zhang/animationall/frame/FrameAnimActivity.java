package com.zhang.animationall.frame;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zhang.animationall.R;


public class FrameAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView example;
    private AnimationDrawable frameAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);

        example = (ImageView) findViewById(R.id.example);
        findViewById(R.id.anim1).setOnClickListener(this);
        findViewById(R.id.anim2).setOnClickListener(this);
        findViewById(R.id.anim3).setOnClickListener(this);
        findViewById(R.id.anim4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anim1:
                example.setBackgroundResource(R.drawable.walk);
                frameAnim = (AnimationDrawable) example.getBackground();
                frameAnim.start();
                break;
            case R.id.anim2:
                example.setBackgroundResource(R.drawable.jump);
                frameAnim = (AnimationDrawable) example.getBackground();
                frameAnim.start();
                break;
            case R.id.anim3:
                example.setBackgroundResource(R.drawable.running);
                frameAnim = (AnimationDrawable) example.getBackground();
                frameAnim.start();
                break;
            case R.id.anim4:
                frameAnim = new AnimationDrawable();

                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d0), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d1), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d2), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d3), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d4), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d5), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d6), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d7), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d8), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d9), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d10), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d11), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d12), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d13), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d14), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d15), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d16), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d17), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d18), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d19), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d20), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d21), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d22), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d23), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d24), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d25), 100);
                frameAnim.addFrame(getResources().getDrawable(R.mipmap.d26), 100);
                example.setBackgroundDrawable(frameAnim);
                frameAnim.start();
                break;
        }

    }
}

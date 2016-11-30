package com.zhang.animationall.tween;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.zhang.animationall.R;

public class MixAnimActivity extends AppCompatActivity {

    private ImageView example;

    private Button go;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_anim);

        example = (ImageView) this.findViewById(R.id.example);

        go = (Button) this.findViewById(R.id.go);

        animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.animset);

        Animation animation = new ThreeDRotateAnimation(0, 360, 0, 0, 100, 1);
        animation.setDuration(3000);
        animation.setStartOffset(6000);
        animationSet.addAnimation(animation);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                example.startAnimation(animationSet);
                v.startAnimation(animationSet);
            }
        });
    }
}

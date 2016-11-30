package com.zhang.animationall.materialdesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.animation.BounceInterpolator;

import com.zhang.animationall.R;

public class MaterialDesignActivity extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setInterpolator(new BounceInterpolator()).setDuration(3000));
        getWindow().setExitTransition(new Fade().setDuration(3000));
        getWindow().setReturnTransition(new Slide().setDuration(3000));
        getWindow().setReenterTransition(new Slide().setDuration(3000));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);


        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, MaterialAnimActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btn2:
                startActivity(new Intent(this, MaterialAnimEffect1Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.btn3:
                startActivity(new Intent(this, MaterialAnimEffect2Activity.class),
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }
}

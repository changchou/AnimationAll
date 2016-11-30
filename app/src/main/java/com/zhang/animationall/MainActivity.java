package com.zhang.animationall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhang.animationall.frame.FrameAnimActivity;
import com.zhang.animationall.frame.InterpolatorActivity;
import com.zhang.animationall.frame.ViewAnimActivity;
import com.zhang.animationall.materialdesign.MaterialDesignActivity;
import com.zhang.animationall.property.LayoutAnimActivity;
import com.zhang.animationall.property.PropertyAnimActivity;
import com.zhang.animationall.tween.CustomAnimActivity;
import com.zhang.animationall.tween.MixAnimActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCustomAnim(View view) {
        startActivity(new Intent(this, CustomAnimActivity.class));
    }

    public void onClickMixAnim(View view) {
        startActivity(new Intent(this, MixAnimActivity.class));
    }

    public void onClickFrameAnim(View view) {
        startActivity(new Intent(this, FrameAnimActivity.class));
    }

    public void onClickInterpolator(View view) {
        startActivity(new Intent(this, InterpolatorActivity.class));
    }

    public void onClickMix(View view) {
        startActivity(new Intent(this, ViewAnimActivity.class));
    }

    public void onClickProperty(View view) {
        startActivity(new Intent(this, PropertyAnimActivity.class));
    }

    public void onClickLayoutAnim(View view) {
        startActivity(new Intent(this, LayoutAnimActivity.class));
    }

    public void onClickMaterialDesign(View view) {
        startActivity(new Intent(this, MaterialDesignActivity.class));
    }
}

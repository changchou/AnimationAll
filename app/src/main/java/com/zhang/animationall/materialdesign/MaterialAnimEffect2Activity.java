package com.zhang.animationall.materialdesign;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;

import com.zhang.animationall.R;

public class MaterialAnimEffect2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ball;
    private Path sTraversalPath = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setDuration(6000));
        getWindow().setExitTransition(new Fade().setDuration(6000));
        getWindow().setReturnTransition(new Slide().setDuration(6000));
        getWindow().setReenterTransition(new Slide().setDuration(6000));
        getWindow().setSharedElementEnterTransition(new ChangeBounds().setInterpolator(new BounceInterpolator()).setDuration(6000));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_anim_effect2);

        ball = (ImageView) findViewById(R.id.ball);

        findViewById(R.id.p1).setOnClickListener(this);
        findViewById(R.id.p2).setOnClickListener(this);
        findViewById(R.id.p3).setOnClickListener(this);
        findViewById(R.id.p4).setOnClickListener(this);
        findViewById(R.id.avd).setOnClickListener(this);
        findViewById(R.id.heart).setOnClickListener(this);

        RectF bounds = new RectF(0, 200, 600, 800);
        sTraversalPath.addArc(bounds, 180, -180);
    }

    @Override
    public void onClick(View v) {
        Animator animatorX, animatorY, animator;
        PropertyValuesHolder x, y;
        switch (v.getId()) {
            case R.id.p1:
                animator = ObjectAnimator.ofFloat(ball, View.X, View.Y, sTraversalPath).setDuration(6000);
                animator.setInterpolator(new PathInterpolator(0.4f, 0, 0.2f, 1));
                animator.start();
                break;
            case R.id.p2:
                animatorX = ObjectAnimator.ofFloat(ball, "x", 0, 600).setDuration(6000);
                animatorY = ObjectAnimator.ofFloat(ball, "y", 800, 200).setDuration(6000);
                animatorX.setInterpolator(new LinearInterpolator());
                animatorY.setInterpolator(new PathInterpolator(0.4f, 0, 0.2f, 1));
                animatorX.start();
                animatorY.start();
                break;
            case R.id.p3:
                animatorX = ObjectAnimator.ofFloat(ball, "x", 0, 600).setDuration(6000);
                animatorY = ObjectAnimator.ofFloat(ball, "y", 800, 200).setDuration(6000);
                animatorX.setInterpolator(new LinearInterpolator());
                animatorY.setInterpolator(new AccelerateInterpolator());
                animatorX.start();
                animatorY.start();
                break;
            case R.id.p4:
                animatorX = ObjectAnimator.ofFloat(ball, "x", 0, 600).setDuration(6000);
                animatorY = ObjectAnimator.ofFloat(ball, "y", 800, 200).setDuration(6000);
                animatorX.setInterpolator(new LinearInterpolator());
                animatorY.setInterpolator(new BounceInterpolator());
                animatorX.start();
                animatorY.start();
                break;
            case R.id.avd:
                ((Animatable) ((ImageView) v).getDrawable()).start();
                break;
            case R.id.heart:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();
    }
}

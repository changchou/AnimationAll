package com.zhang.animationall.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.zhang.animationall.R;

public class MaterialAnimEffect1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setInterpolator(new BounceInterpolator()).setDuration(6000));
        getWindow().setExitTransition(new Fade().setDuration(6000));
        getWindow().setReturnTransition(new Slide().setDuration(6000));
        getWindow().setReenterTransition(new Slide().setDuration(6000));
        getWindow().setSharedElementReenterTransition(new ChangeTransform().setInterpolator(new BounceInterpolator()).setDuration(6000));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_anim_effect1);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.p1).setOnClickListener(this);
        findViewById(R.id.p2).setOnClickListener(this);
        findViewById(R.id.p3).setOnClickListener(this);
        findViewById(R.id.p4).setOnClickListener(this);
        findViewById(R.id.transition).setOnClickListener(this);
        findViewById(R.id.shareTransition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Animator animator;
        switch (v.getId()) {
            case R.id.p1:
                animator = ViewAnimationUtils.createCircularReveal(
                        btn,
                        btn.getWidth() / 2,
                        btn.getHeight() / 2,
                        0,
                        btn.getWidth());
                animator.setInterpolator(new LinearInterpolator());

                animator.setDuration(3000);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        btn.setVisibility(View.VISIBLE);
                    }
                });
                animator.start();
                break;
            case R.id.p2:
                animator = ViewAnimationUtils.createCircularReveal(
                        btn,
                        btn.getWidth() / 2,
                        btn.getHeight() / 2,
                        btn.getWidth(),
                        0
                );
                animator.setInterpolator(new LinearInterpolator());

                animator.setDuration(3000);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        btn.setVisibility(View.GONE);
                    }
                });
                animator.start();
                break;
            case R.id.transition:
                startActivity(new Intent(this, MaterialAnimEffect2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.shareTransition:

                View sharedView = findViewById(R.id.p1);
                String transitionName = "p1";

                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, sharedView, transitionName);

                startActivity(new Intent(this, MaterialAnimEffect2Activity.class), transitionActivityOptions.toBundle());

                //  ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                //          Pair.create(view1, "agreedName1"),
                //          Pair.create(view2, "agreedName2"));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();
    }
}

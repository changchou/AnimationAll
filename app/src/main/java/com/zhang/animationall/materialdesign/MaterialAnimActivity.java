package com.zhang.animationall.materialdesign;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.animationall.R;

public class MaterialAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView, txt00, txt01, txt02, txt03, txt10, txt11, txt12, txt13;
    private ImageView ball;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setDuration(3000));
        getWindow().setExitTransition(new Fade().setDuration(3000));
        getWindow().setReturnTransition(new Slide().setDuration(3000));
        getWindow().setReenterTransition(new Slide().setDuration(3000));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_anim);

        ball = (ImageView) findViewById(R.id.ball);
        textView = (TextView) findViewById(R.id.textView);
        txt00 = (TextView) findViewById(R.id.txt00);
        txt01 = (TextView) findViewById(R.id.txt01);
        txt02 = (TextView) findViewById(R.id.txt02);
        txt03 = (TextView) findViewById(R.id.txt03);
        txt10 = (TextView) findViewById(R.id.txt10);
        txt11 = (TextView) findViewById(R.id.txt11);
        txt12 = (TextView) findViewById(R.id.txt12);
        txt13 = (TextView) findViewById(R.id.txt13);

        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.p1).setOnClickListener(this);
        findViewById(R.id.p2).setOnClickListener(this);
        findViewById(R.id.p3).setOnClickListener(this);
        findViewById(R.id.p4).setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        ObjectAnimator a1, a2;
        switch (v.getId()) {
            case R.id.btn:
                //触控反应，涟漪、抬高  5.0自带
                break;
            case R.id.btn2:
                //从接触点开始动画
                //方法一
                textView.setPivotX(0);
                textView.setPivotY(textView.getHeight());
                ObjectAnimator.ofFloat(textView, "scaleX", 0, 1).setDuration(2000).start();
                ObjectAnimator.ofFloat(textView, "scaleY", 0, 1).setDuration(2000).start();

                //方法二
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        textView,
                        0,
                        textView.getHeight(),
                        0,
                        textView.getWidth());
                animator.setInterpolator(new LinearInterpolator());
                animator.setStartDelay(4000);
                animator.setDuration(2000);
                animator.start();
                break;
            case R.id.p1:
                //从静止开始要有加速过程，最终静止要有减速过程
                float yf = ball.getY();
                a1 = ObjectAnimator.ofFloat(ball, "y", 150F).setDuration(2000);
                a1.setInterpolator(new AccelerateDecelerateInterpolator());
                a2 = ObjectAnimator.ofFloat(ball, "y", 150F, yf).setDuration(2000);
                a2.setInterpolator(new AccelerateDecelerateInterpolator());
                a2.setStartDelay(2500);
                a1.start();
                a2.start();
                break;
            case R.id.p2:
                //快速进场，快速退场
                float yf2 = ball.getY();
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(ball, "y", yf2 + 200, 150F).setDuration(2000);
                objectAnimator3.setInterpolator(new DecelerateInterpolator());
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(ball, "y", 150F, yf2 + 200).setDuration(2000);
                objectAnimator4.setStartDelay(2500);
                objectAnimator4.setInterpolator(new AccelerateInterpolator());
                objectAnimator3.start();
                objectAnimator4.start();
                break;
            case R.id.p3:
                //层次动画时间差
                ObjectAnimator.ofFloat(txt00, "scaleX", 1, 0).setDuration(500).start();
                ObjectAnimator.ofFloat(txt00, "scaleY", 1, 0).setDuration(500).start();

                a1 = ObjectAnimator.ofFloat(txt01, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt01, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(250);
                a2.setStartDelay(250);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt10, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt10, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(250);
                a2.setStartDelay(250);
                a1.start();
                a2.start();


                a1 = ObjectAnimator.ofFloat(txt02, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt02, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(500);
                a2.setStartDelay(500);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt11, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt11, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(500);
                a2.setStartDelay(500);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt12, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt12, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(750);
                a2.setStartDelay(750);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt03, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt03, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(750);
                a2.setStartDelay(750);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt13, "scaleX", 1, 0).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt13, "scaleY", 1, 0).setDuration(500);
                a1.setStartDelay(1000);
                a2.setStartDelay(1000);
                a1.start();
                a2.start();
                break;
            case R.id.p4:
                ObjectAnimator.ofFloat(txt00, "scaleX", 0, 1).setDuration(500).start();
                ObjectAnimator.ofFloat(txt00, "scaleY", 0, 1).setDuration(500).start();

                a1 = ObjectAnimator.ofFloat(txt01, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt01, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(250);
                a2.setStartDelay(250);
                a1.start();
                a2.start();


                a1 = ObjectAnimator.ofFloat(txt10, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt10, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(250);
                a2.setStartDelay(250);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt02, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt02, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(500);
                a2.setStartDelay(500);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt11, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt11, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(500);
                a2.setStartDelay(500);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt12, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt12, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(750);
                a2.setStartDelay(750);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt03, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt03, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(750);
                a2.setStartDelay(750);
                a1.start();
                a2.start();

                a1 = ObjectAnimator.ofFloat(txt13, "scaleX", 0, 1).setDuration(500);
                a2 = ObjectAnimator.ofFloat(txt13, "scaleY", 0, 1).setDuration(500);
                a1.setStartDelay(1000);
                a2.setStartDelay(1000);
                a1.start();
                a2.start();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();
    }
}

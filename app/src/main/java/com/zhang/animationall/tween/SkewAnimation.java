package com.zhang.animationall.tween;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Mr.Z on 2016/11/28 0028.
 */

public class SkewAnimation extends Animation {
    private float mSkewX;
    private float mSkewY;
    private Camera mCamera;
    private int type;

    public SkewAnimation(float mSkewX, float mSkewY) {
        this.mSkewX = mSkewX;
        this.mSkewY = mSkewY;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }


    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float skewX = mSkewX * interpolatedTime;
        float skewY = mSkewY * interpolatedTime;
        final Matrix matrix = t.getMatrix();
        matrix.preSkew(skewX, skewY);
    }
}

package com.zhang.animationall.tween;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Mr.Z on 2016/11/28 0028.
 */

public class ThreeDRotateAnimation extends Animation {
    private float mFromDegrees;
    private float mToDegrees;
    private float mCenterX;
    private float mCenterY;
    private float mDepthZ;
    private Camera mCamera;
    private int type;

    /**
     * @param mFromDegrees
     * @param mToDegrees
     * @param mCenterX
     * @param mCenterY
     * @param mDepthZ
     * @param type
     */
    public ThreeDRotateAnimation(float mFromDegrees, float mToDegrees, float mCenterX, float mCenterY, float mDepthZ, int type) {
        this.mFromDegrees = mFromDegrees;
        this.mToDegrees = mToDegrees;
        this.mCenterX = mCenterX;
        this.mCenterY = mCenterY;
        this.mDepthZ = mDepthZ;
        this.type = type;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        if(type==1)
        {
            myTransformation(interpolatedTime,t);
            return;
        }

        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.rotateY(degrees);
        mCamera.rotateX(degrees);
        mCamera.getMatrix(matrix);
        mCamera.restore();
        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);
    }

    private void myTransformation(float interpolatedTime, Transformation t) {

        float degrees = mFromDegrees + ((mToDegrees - mFromDegrees) * interpolatedTime);
        float degreespi=(float)(2*Math.PI*degrees/360);
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.translate((float) (mDepthZ * Math.sin(degreespi)), 0.0f, (float) (1 - Math.cos(degreespi)) * mDepthZ);
        mCamera.rotateY(degrees);
        mCamera.getMatrix(matrix);
        mCamera.restore();
        matrix.preTranslate(-mCenterX, -mCenterY);
        matrix.postTranslate(mCenterX, mCenterY);

    }
}

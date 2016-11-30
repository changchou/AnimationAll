package com.zhang.animationall.frame;

import android.view.animation.Interpolator;

/**
 * Created by Mr.Z on 2016/11/28 0028.
 */

public class GravityInterpolator implements Interpolator {
    //extends BaseInterpolator implements NativeInterpolatorFactory //API 22

    @Override
    public float getInterpolation(float input) {
        float f = 0;
        if (input < 0.5f) {
            f = 4 * input - 1f;
            return 1f - f * f;
        } else {
            f = input - 0.5f;
            f = (4 * f - 1f);
            return (1f - f * f) * 0.4f;
        }
    }
}

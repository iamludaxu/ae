package gift.witch.android.ae.animation;

import android.animation.TimeInterpolator;


/***
 *
 * 预览android动画
 *
 * http://inloop.github.io/interpolator/
 */
public class MyInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        /**
         * input float类型 0.0-1.0
         */
        return cubicHermite(input, 0.0f, 1.0f, 4.0f, 4.0f);
    }

    private float cubicHermite(float t, float p0, float p1, float m0, float m1){
        float t2 = t*t;
        float t3 = t2*t;
        return (2*t3 - 3*t2 + 1)*p0 + (t3-2*t2+t)*m0 + (-2*t3+3*t2)*p1 + (t3-t2)*m1;
    }

}

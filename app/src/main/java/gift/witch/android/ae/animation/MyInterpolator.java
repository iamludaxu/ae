package gift.witch.android.ae.animation;

import android.graphics.Interpolator;

public class MyInterpolator extends Interpolator{

    public MyInterpolator(int valueCount) {
        super(valueCount);
    }

    public MyInterpolator(int valueCount, int frameCount) {
        super(valueCount, frameCount);
    }


}

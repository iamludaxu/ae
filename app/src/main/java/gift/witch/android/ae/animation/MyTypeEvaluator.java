package gift.witch.android.ae.animation;

import android.animation.TypeEvaluator;

import com.orhanobut.logger.Logger;

public class MyTypeEvaluator implements TypeEvaluator<Float> {

    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        float startInt = startValue;
        float result = (int) (startInt + fraction * (endValue - startInt));
        Logger.i("result:" + result + "==startInt:" + startInt + "==fraction:" + fraction + "==endValue:" + endValue);
        return result;
    }
}

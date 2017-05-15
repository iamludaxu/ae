package gift.witch.android.ae.animation;

import android.animation.TypeEvaluator;

import com.orhanobut.logger.Logger;

/**
 *
 * 转换器
 *
 */
public class MyTypeEvaluator implements TypeEvaluator<Float> {

    /**
     *
     * 根据插值转换值
     *
     * @param fraction 插值器的因子
     * @param startValue 起始的值
     * @param endValue 最终的值
     * @return
     */
    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        float startInt = startValue;
        float result = (int) (startInt + fraction * (endValue - startInt));
        Logger.i("result:" + result + "==startInt:" + startInt + "==fraction:" + fraction + "==endValue:" + endValue);
        return result;
    }
}

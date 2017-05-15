package gift.witch.android.ae.animation;

import android.animation.TypeEvaluator;
import android.graphics.RectF;

import com.orhanobut.logger.Logger;


/**
 * 矩形压扁
 */
public class RectFEvaluator implements TypeEvaluator<RectF> {

    @Override
    public RectF evaluate(float fraction, RectF startValue, RectF endValue) {
        RectF temp = new RectF();
        float top = startValue.top + (endValue.top - startValue.top)*fraction;
        float bottom = startValue.bottom + (endValue.bottom - startValue.bottom)*fraction;
        temp.set(startValue.left,top,startValue.right,bottom);

        Logger.i(temp.toString());
        return temp;
    }
}

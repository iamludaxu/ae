package gift.witch.android.ae.animation;


import android.animation.TypeEvaluator;

import com.orhanobut.logger.Logger;


/**
 *
 * 起始值和结束值长度需要一样
 *
 */
public class StringEvaluator implements TypeEvaluator<String>{

    @Override
    public String evaluate(float fraction, String startValue, String endValue) {
        if(startValue.length()!=endValue.length()){
            return "startValue！=endValue";
        }
        int size = startValue.length();
        int pos = (int)(fraction*size);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startValue.substring(0,pos));
        stringBuilder.append(endValue.substring(pos,endValue.length()));
        Logger.i("size:"+size +"==pos:"+pos+"==string"+stringBuilder.toString());
        return stringBuilder.toString();
    }
}

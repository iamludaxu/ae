package gift.witch.glide;

import android.animation.ValueAnimator;
import android.view.View;

import com.bumptech.glide.request.transition.ViewPropertyTransition;

public class MyAnimator implements ViewPropertyTransition.Animator {

    @Override
    public void animate(View view) {
        final View finalView = view;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(10000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                finalView.setScaleX((float) (0.5 + 0.5 * value));
                finalView.setScaleY((float) (0.5 + 0.5 * value));
                finalView.setRotation(180* value);
                finalView.setAlpha(value);
            }
        });
        valueAnimator.start();
    }
}

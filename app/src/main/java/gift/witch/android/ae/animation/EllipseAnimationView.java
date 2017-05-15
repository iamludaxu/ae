package gift.witch.android.ae.animation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;


/**
 *
 * 自定义椭圆压扁动画
 *
 */
public class EllipseAnimationView extends View {

    private Paint mPaint;
    private RectF mRectF;
    private RectF mStart;
    private RectF mEnd;

    public EllipseAnimationView(Context context) {
        super(context);
        init();
    }

    public EllipseAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EllipseAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mStart= new RectF();
        mStart.set(0, 0, 200, 200);
        mEnd = new RectF();
        mEnd.set(mStart.left, mStart.top + 50, mStart.right, mStart.bottom - 50);
        mRectF = mStart;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(mRectF, mPaint);
    }

    /**
     *
     * 启动动画
     *
     */
    public void doAnim() {

        ValueAnimator animator = ValueAnimator.ofObject(new RectFEvaluator(), mStart, mEnd);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mRectF = (RectF) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

}

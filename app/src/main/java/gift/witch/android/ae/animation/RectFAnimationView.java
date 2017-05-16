package gift.witch.android.ae.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 通过ObjectAnimator对View进行动画
 *
 */
public class RectFAnimationView extends View {

    private Paint mPaint;
    private RectF mRectF;
    private RectF mStart;
    private RectF mEnd;

    public RectFAnimationView(Context context) {
        super(context);
        init();
    }

    public RectFAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectFAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        mRectF = mStart;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRectF, mPaint);
    }

    /**
     * 设置动画
     * @param rectF
     */
    public void setRectF(RectF rectF){
        mRectF = rectF;
        invalidate();
    }

    /**
     * 在没有初始化值的时候会调用get方法
     * @return
     */
    public RectF getRectF(){
        return mStart;
    }

}

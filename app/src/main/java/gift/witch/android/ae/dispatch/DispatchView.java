package gift.witch.android.ae.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class DispatchView extends TextView {

    private final static String TAG = "DispatchView";

    public DispatchView(Context context) {
        super(context);
    }

    public DispatchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        DispatchUtil.print(TAG,"dispatchTouchEvent",event);
        return super.dispatchTouchEvent(event);
        /**
         * 如果是true就直接onTouchEvent消费掉
         */
        //return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        DispatchUtil.print(TAG,"onTouchEvent",event);
        //return super.onTouchEvent(event);
        /**
         * 如果是true，直接被消费掉
         */
        return true;
    }
}

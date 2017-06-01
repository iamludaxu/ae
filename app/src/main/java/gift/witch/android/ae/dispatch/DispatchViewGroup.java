package gift.witch.android.ae.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class DispatchViewGroup extends LinearLayout {

    private final static String TAG = "DispatchViewGroup";
    public DispatchViewGroup(Context context) {
        super(context);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        DispatchUtil.print(TAG,"dispatchTouchEvent",ev);
        //return super.dispatchTouchEvent(ev);

        /**
         * 如果是true就直接onTouchEvent消费掉
         */
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        DispatchUtil.print(TAG,"onInterceptTouchEvent",ev);
        return super.onInterceptTouchEvent(ev);
        /**
         * 如果true就直接onTouchEvent消费掉
         */
        //return true;

        /**
         * 默认是false
         */
        //return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        DispatchUtil.print(TAG,"onTouchEvent",event);
        return super.onTouchEvent(event);

        /**
         * 如果是true，直接被消费掉
         */
        //return true;
    }







}

package gift.witch.android.ae.dispatch;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.orhanobut.logger.Logger;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

/**
 *
 * https://iamludaxu.gitbooks.io/android/content/shi-jian-fen-fa.html
 *
 */
public class DispatchActivity extends BaseCompatActivity implements View.OnClickListener, View.OnTouchListener {



    private final static String TAG = "DispatchActivity";

    private DispatchViewGroup mDispatchViewGroup;

    private DispatchView mDispatchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dispatch);

        mDispatchView = (DispatchView)findViewById(R.id.dispathview);
        mDispatchViewGroup = (DispatchViewGroup) findViewById(R.id.dispathvg);
        //mDispatchViewGroup.setOnTouchListener(this);
        mDispatchView.setOnClickListener(this);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        DispatchUtil.print(TAG,"dispatchTouchEvent",ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Logger.i("DispatchActivity  onClick");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        DispatchUtil.print(TAG,"onTouchEvent",event);
        return true;
    }
}

package gift.witch.android.ae.okhttp;

import android.os.Bundle;
import android.view.View;

import com.orhanobut.logger.Logger;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;
import okhttp3.Call;

/**
 *
 * OkHttp
 *
 * https://iamludaxu.gitbooks.io/android/content/okhttp.html
 *
 */
public class OkHttpActivity extends BaseCompatActivity implements View.OnClickListener {


    private String TAG = "OkHttpActivity";

    private OkHttpExample mOkHttpExample = new OkHttpExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }


    private Call mCall;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn1){
            mCall = mOkHttpExample.test1();
        }else if(v.getId() == R.id.btn2){
            if(mCall != null){
                Logger.i("isCanceled:"+mCall.isCanceled() + "  isExecuted:" + mCall.isExecuted());
                if(!mCall.isCanceled()){
                    mCall.cancel();
                    Logger.i("cancel /n isCanceled:"+mCall.isCanceled() + "  isExecuted:" + mCall.isExecuted());
                }
            }

        }
    }
}

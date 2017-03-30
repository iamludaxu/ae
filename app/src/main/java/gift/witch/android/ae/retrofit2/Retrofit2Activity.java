package gift.witch.android.ae.retrofit2;

import android.os.Bundle;
import android.view.View;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

/**
 *
 * Retrofit
 *
 * https://iamludaxu.gitbooks.io/android/content/retrofit.html
 *
 */
public class Retrofit2Activity extends BaseCompatActivity implements View.OnClickListener {


    private String TAG = "Retrofit2Activity";

    private RetrofitManage mRetrofitManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mRetrofitManage = new RetrofitManage();
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if(vId == R.id.button1){
            mRetrofitManage.conerter();
        }else if (vId == R.id.button2){
            mRetrofitManage.test();
        }


    }
}

package gift.witch.android.ae.butterKnife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

public class ButterKnifeActivity extends BaseCompatActivity {


    public static void start(Activity activity){
        Intent intent = new Intent();
        intent.setClass(activity,ButterKnifeActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
    }
}

package gift.witch.android.ae.base;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseCompatActivity extends AppCompatActivity {

    public static void start(Activity activity,Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(activity,cls);
        activity.startActivity(intent);
    }


}

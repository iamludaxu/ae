package gift.witch.android.ae.test;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.orhanobut.logger.Logger;

/**
 *
 */
public class RobolectricIntentService extends IntentService {

    public RobolectricIntentService() {
        super("RobolectricIntentService");
    }


    @Override
    public void onHandleIntent(Intent intent) {
        Logger.i(intent.toString());
        Logger.i(getApplicationContext().getPackageName());
        SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(
                "datas", Context.MODE_PRIVATE).edit();
        String data0 = intent.getStringExtra("data0");
        Logger.i(data0);
        editor.putString("data0", data0);
        editor.apply();
    }
}
package gift.witch.android.ae.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


/**
 *
 */
public class RobolectricReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                "datas", Context.MODE_PRIVATE).edit();
        String data = intent.getStringExtra("data");
        editor.putString("data", data);
        editor.apply();
    }
}

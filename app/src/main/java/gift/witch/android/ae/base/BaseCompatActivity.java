package gift.witch.android.ae.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

public class BaseCompatActivity extends AppCompatActivity {

    public static void start(Activity activity, String title, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtra("TITLE", title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            String title = this.getIntent().getStringExtra("TITLE");
            if (!TextUtils.isEmpty(title)) {
                actionBar.setTitle(title);
            }
        }
    }

}

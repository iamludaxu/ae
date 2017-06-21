package gift.witch.android.ae.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

public class RobolectricActivity extends BaseCompatActivity {


    private String TAG = "RobolectricActivity";

    private TextView mTextTV;
    private CheckBox mCheckBoxCB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robolectric);
        setTitle(TAG);
        mTextTV = (TextView) findViewById(R.id.text);
        mTextTV.setText("onCreate");
        mCheckBoxCB = (CheckBox) findViewById(R.id.checkbox);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RobolectricActivity.this,NextRobolectricActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.toast_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"toast_btn onClick ");
                Logger.i(TAG+"Logger toast_btn onClick");
                Toast.makeText(RobolectricActivity.this,"I'm HaHa",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mTextTV.setText("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mTextTV.setText("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mTextTV.setText("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTextTV.setText("onDestroy");
    }
}

package gift.witch.android.ae.display;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

/**
 *
 *
 * https://iamludaxu.gitbooks.io/android/content/architect.html
 *
 */
public class DisplayActivity extends BaseCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView text =  (TextView)findViewById(R.id.text);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        text.setText(displayMetrics.toString());

        /**
         * 这里设置字体的单位，默认是sp
         */
        text.setTextSize(TypedValue.COMPLEX_UNIT_DIP ,14);

        /**
         * 获取相应的单位值
         */
        float value = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,14,displayMetrics);
        /**
         * dip 转 px
         */
        int pxValue = DisplayUtil.dip2px(this,value);
        text.setPadding(pxValue,pxValue,pxValue,pxValue);

    }


}

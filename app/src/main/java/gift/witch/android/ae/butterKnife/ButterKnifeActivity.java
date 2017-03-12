package gift.witch.android.ae.butterKnife;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

/**
 *
 * ButterKnife
 *
 * https://iamludaxu.gitbooks.io/android/content/butterknife.html
 *
 */
public class ButterKnifeActivity extends BaseCompatActivity {



    private Unbinder mUnbinder;

    /**
     * 绑定资源
     *
     * @BindString()
     * @BindColor()
     * @BindDrawable()
     * @BindDimen()
     * ...
     * @BindBool()
     *
     */
    @BindString(R.string.app_name)
    String mAppName;

    @BindView(R.id.button1)
    Button mButton1BTN;

    /**
     * 绑定事件
     * @OnItemSelected()
     * @OnTextChanged()
     * ....
     * @OnItemLongClick()
     */
    @OnClick({R.id.button1,R.id.button2})
    public void doButton(Button button){
        Toast.makeText(this,"点击了按钮:" + button.getText(),Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_butterknife);
        /**
         * 一定要在 setContentView 之后，不然所有元素为空
         */
        mUnbinder =  ButterKnife.bind(this);
        /**
         * 如果注释的元素为空，可能是gradle中没有配apt
         */
        mButton1BTN.setText(mAppName);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}

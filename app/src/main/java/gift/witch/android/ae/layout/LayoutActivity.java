package gift.witch.android.ae.layout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

public class LayoutActivity extends BaseCompatActivity implements View.OnClickListener {


    private String TAG = "LayoutActivity";

    private TableLayout mTableLayout;

    private AbsoluteLayout mAbsoluteLayout;

    private FrameLayout mFrameLayout;

    private LinearLayout mLinearLayout;

    private RelativeLayout mRelativeLayout;

    private ViewStub mViewStub;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.top);
        int childCount = linearLayout.getChildCount();
        Logger.i(TAG+"childCount:"+childCount);

        mViewStub = (ViewStub)findViewById(R.id.stub);
        mViewStub.setLayoutResource(R.layout.view_layout);

        findViewById(R.id.text).setOnClickListener(this);

        /****
         * 布局内容
         */
        //LayoutInflater.from(this).inflate()
    }


    @Override
    public void onClick(View v) {
        int vId = v.getId();
        mViewStub.inflate();
    }


    private void tableLayout(){
        mTableLayout = new TableLayout(this);
    }


    /**
     * AbsoluteLayout被弃用 可以用其他布局代替
     */
    private void absoluteLayout(){
        mAbsoluteLayout = new AbsoluteLayout(this);
    }


    /**
     * FrameLayout
     */
    private void frameLayout(){
        /**
         * 默认子元素从左上角开始布局
         *
         * 子元素可以用layout_gravity限定位置
         *
         */
        mFrameLayout = new FrameLayout(this);

        FrameLayout.LayoutParams flLP = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.WRAP_CONTENT);
        mFrameLayout.addView(new TextView(this),flLP);

    }

    /**
     * LinearLayout
     */
    private void linearLayout(){

        mLinearLayout = new LinearLayout(this);
        /**
         * 默认是HORIZONTAL
         * 当HORIZONTAL时，gravity只能对左右布局，子元素layout_gravity左右布局失效
         *
         * 当VERTICAL时，gravity只能对上下布局，子元素layout_gravity上下布局失效
         */
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);

        /**
         * 一共的权重
         */
        mLinearLayout.setWeightSum(1);

        /**
         * 插入间隔图片
         */
        mLinearLayout.setDividerDrawable(this.getResources().getDrawable(R.drawable.shap_line));
        mLinearLayout.setDividerPadding(3);
        mLinearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING);

        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        /**
         * 子元素权重
         */
        llLP.weight = 1.0f;

        mLinearLayout.addView(new TextView(this),llLP);
    }


    /**
     * RelativeLayout
     */
    private void relativeLayout(){

        mRelativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlLP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);

        /**********************************************
         *根据父容器布局
         */
        /**
         * 父容器顶部
         */
        rlLP.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        /**
         * 父容器左边
         */
        rlLP.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        /**
         * 父容器右边
         */
        rlLP.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        /**
         * 父容器底部
         */
        rlLP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        /**
         * 父容器水平居中
         */
        rlLP.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
        /**
         * 父容器垂直居中
         */
        rlLP.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);
        /**
         * 父容器居中
         */
        rlLP.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);


        /***********************************************
         * 根据兄弟布局
         */
        /**
         * 在某个元素的下面
         */
        rlLP.addRule(RelativeLayout.BELOW,R.id.text);
        /**
         * 在某个元素的上面面
         */
        rlLP.addRule(RelativeLayout.ABOVE,R.id.text);
        /**
         * 在某个元素的左边
         */
        rlLP.addRule(RelativeLayout.LEFT_OF,R.id.text);
        /**
         * 在某个元素的右边
         */
        rlLP.addRule(RelativeLayout.RIGHT_OF,R.id.text);

        /**
         *参考某个元素的下边界
         */
        rlLP.addRule(RelativeLayout.ALIGN_BOTTOM,R.id.text);
        /**
         *参考某个元素的上边界
         */
        rlLP.addRule(RelativeLayout.ALIGN_TOP,R.id.text);
        /**
         *参考某个元素的左边界
         */
        rlLP.addRule(RelativeLayout.ALIGN_LEFT,R.id.text);
        /**
         *参考某个元素的右边界
         */
        rlLP.addRule(RelativeLayout.ALIGN_RIGHT,R.id.text);

        /**
         * 内容的基准线
         */
        rlLP.addRule(RelativeLayout.ALIGN_BASELINE,R.id.text);
    }

}

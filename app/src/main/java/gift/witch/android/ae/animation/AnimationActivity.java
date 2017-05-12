package gift.witch.android.ae.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

public class AnimationActivity extends BaseCompatActivity implements View.OnClickListener {


    private Button mBtn;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;

    private TextView mBgTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animation);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn4.setOnClickListener(this);

        mBgTV = (TextView)findViewById(R.id.bg);
        mBgTV.setBackgroundResource(R.drawable.frame_anim);
        mBgTV.setOnClickListener(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn) {

            /**
             * ObjectAnimator
             */
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mBtn, "rotationX", 0.0F, 360.0F)
                    .setDuration(500);
            objectAnimator.setInterpolator(new AccelerateInterpolator());
            objectAnimator.start();

        } else if (v.getId() == R.id.btn1) {

            /**
             * ValueAnimator
             */
            ValueAnimator animator = ValueAnimator.ofFloat(0, 360.0F);
            animator.setDuration(500).start();
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mBtn1.setRotationX((Float) animation.getAnimatedValue());
                }
            });
        } else if (v.getId() == R.id.btn2) {

            /**
             * PropertyValuesHolder
             */
            PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("rotationX", 0f, 360f);
            ObjectAnimator.ofPropertyValuesHolder(mBtn2, pvhZ).setDuration(500).start();

        } else if (v.getId() == R.id.btn3) {

            /**
             * AnimatorSet
             */
            ObjectAnimator animatorA = ObjectAnimator.ofFloat(mBtn2, "TranslationX", -300, 300, 0);
            ObjectAnimator animatorB = ObjectAnimator.ofFloat(mBtn2, "scaleY", 0.5f, 1.5f, 1f);
            ObjectAnimator animatorC = ObjectAnimator.ofFloat(mBtn1, "rotation", 0, 270, 90, 180, 0);

            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.play(animatorA).after(animatorC).before(animatorB);
            animatorSet3.setDuration(3*1000);
            animatorSet3.start();
        } else if(v.getId() == R.id.btn4){

            /**
             * Animation
             */
            Animation animation = new ScaleAnimation(0,1,0,1);
            animation.setDuration(3000);
            //animation.start();
            Animation animation2 = new TranslateAnimation(0,100,0,100);
            animation2.setDuration(3000);

            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(animation);
            animationSet.addAnimation(animation2);
            mBtn4.startAnimation(animationSet);

        } else if(v.getId() == R.id.bg){

            AnimationDrawable animation = (AnimationDrawable) mBgTV.getBackground();
            animation.start();
        }
    }
}

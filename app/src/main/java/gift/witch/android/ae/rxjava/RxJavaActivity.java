package gift.witch.android.ae.rxjava;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;
import rx.Observable;
import rx.Subscriber;

/**
 *
 * RxJava
 *
 * https://iamludaxu.gitbooks.io/android/content/rxjava.html
 *
 */
public class RxJavaActivity extends BaseCompatActivity implements View.OnClickListener {


    private String TAG = "RxJavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        findViewById(R.id.button1).setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int vId = v.getId();
        Observable intervalObservable = Observable.interval(2,1, TimeUnit.SECONDS);//每隔一秒发送一次
        //intervalObservable.subscribe(createIntObserver());

        Subscriber<Long> subscriber = new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted" );
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError:" + e.getMessage());
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("interval:" + aLong);
            }

        };
        intervalObservable.subscribe(subscriber);
    }
}

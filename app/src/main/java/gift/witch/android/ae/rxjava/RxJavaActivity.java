package gift.witch.android.ae.rxjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

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
        /*
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

*/

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .throttleWithTimeout(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
                .subscribe(
                        new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                System.out.println("Next:" + integer);
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                System.out.println("Error:" + throwable.getMessage());
                            }
                        }, new Action0() {
                            @Override
                            public void call() {
                                System.out.println("completed!");
                            }
                        });


        Observable<String> o1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("o1");
                subscriber.onNext("o2");
                subscriber.onNext("o3");
            }
        });
        Observable<String> o2 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("o4");
                subscriber.onNext("o5");
                subscriber.onNext("o6");
            }
        });

        Observable.combineLatest(o2, o1, new Func2<String, String, String>() {
            @Override public String call(String s, String s2) {
                return s + s2;
            }
        }).subscribe(new Observer<String>() {
            @Override public void onCompleted() {
                Log.e("onCompleted --- >", "onCompleted");
            }

            @Override public void onError(Throwable e) {
                Log.e("onError --- >", "onError");

            }

            @Override public void onNext(String o) {
                Log.e("onNext --- >", o);
            }
        });
    }
}

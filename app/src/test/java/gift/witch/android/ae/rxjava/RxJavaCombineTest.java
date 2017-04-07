package gift.witch.android.ae.rxjava;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

public class RxJavaCombineTest {


    @Test
    public void combineLatestTest(){
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
        }).subscribe(ObserverFactory.createObserver());
    }
}

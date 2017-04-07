package gift.witch.android.ae.gson;

import org.junit.Test;

import gift.witch.android.ae.rxjava.ObserverFactory;
import rx.Observable;
import rx.functions.Func1;

public class RxJavaErrorTest {

    @Test
    public void catchTest(){
        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
        justObservable.elementAt(9).onErrorResumeNext(new Func1<Throwable, Observable>() {
            @Override
            public Observable call(Throwable throwable) {
                System.out.print("call Throwable");
                return null;
            }
        }).subscribe(ObserverFactory.createObserver());

        System.out.println("=====================");

        justObservable.elementAt(9).onErrorReturn(new Func1<Throwable, Observable>() {
            @Override
            public Observable call(Throwable throwable) {
                System.out.print("call Throwable");
                return null;
            }
        }).subscribe(ObserverFactory.createObserver());

        System.out.println("=====================");

    }

    @Test
    public void retryTest(){
        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
        justObservable.elementAt(2).retry(1).subscribe(ObserverFactory.createObserver());
    }
}

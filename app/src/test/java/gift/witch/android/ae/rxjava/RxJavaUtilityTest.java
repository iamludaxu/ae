package gift.witch.android.ae.rxjava;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;

public class RxJavaUtilityTest {
    @Test
    public void delayTest(){
        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
        justObservable.delay(3000, TimeUnit.MILLISECONDS).subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void doTest(){
        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
        justObservable.doAfterTerminate(new Action0() {
            @Override
            public void call() {
                System.out.println("doAfterTerminate call");
            }
        });
        justObservable.doOnCompleted(new Action0() {
            @Override
            public void call() {
                System.out.println("doOnCompleted call");
            }
        });
        justObservable.subscribe(ObserverFactory.createObserver());
    }
}

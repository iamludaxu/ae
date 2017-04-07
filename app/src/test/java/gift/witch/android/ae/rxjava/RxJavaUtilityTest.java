package gift.witch.android.ae.rxjava;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class RxJavaUtilityTest {
    @Test
    public void delayTest(){
        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
        justObservable.delay(3000, TimeUnit.MILLISECONDS).subscribe(ObserverFactory.createObserver());
    }
}

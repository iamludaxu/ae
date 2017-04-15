package gift.witch.android.ae.rxjava;


import org.junit.Test;

import rx.Observable;
import rx.functions.Func2;

public class RxJavaMathematicalTest {
    /**
     * 算术运算在java 1.0里有在2.0只保留了concat
     *
     **/

    @Test
    public void concatTest(){
        Observable<Integer> source1 =  Observable.just(1, 2, 5, 6);
        Observable<Integer> source2 =  Observable.just(7, 6, 5, 6);
        Observable.concat(source1,source2).distinct().subscribe(ObserverFactory.createIntObserver());
    }

    @Test
    public void reduceTest(){
        Observable<Integer> source1 =  Observable.just(1, 2, 5, 6);
        source1.reduce(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer +integer2;
            }
        }).distinct().subscribe(ObserverFactory.createIntObserver());
    }

    @Test
    public void collectTest(){
    }







}

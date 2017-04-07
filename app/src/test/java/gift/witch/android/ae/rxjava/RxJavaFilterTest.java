package gift.witch.android.ae.rxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxJavaFilterTest {


    static private List<String> list;

    static {
        list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
    }

    @Test
    public void testDebounce() {

        //在android环境下可以运行
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
                .debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
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

    }

    @Test
    public void distinctTest(){
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinct().subscribe(ObserverFactory.createIntObserver());
    }

    /**
     * 从0开始
     */
    @Test
    public void elementAtTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .elementAt(2).subscribe(ObserverFactory.createIntObserver());
    }

    /**
     * 条件过滤
     */
    @Test
    public void filterTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer>4;
                    }
                }).subscribe(ObserverFactory.createIntObserver());
    }

    /**
     * 第一个元素
     */
    @Test
    public void firstTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .first().subscribe(ObserverFactory.createIntObserver());

        Observable.just(1, 2, 3, 4, 5, 6)
                .first(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer>2;
                    }
                }).subscribe(ObserverFactory.createIntObserver());

    }

    /**
     * 忽略元素
     */
    @Test
    public void ignoreElementsTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .ignoreElements().subscribe(ObserverFactory.createIntObserver());
    }


    /**
     * 满足条件的最后一个元素
     */
    @Test
    public void lastTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .last().subscribe(ObserverFactory.createIntObserver());

        Observable.just(6, 3, 3, 4, 1, 2)
                .last(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer>2;
                    }
                }).subscribe(ObserverFactory.createIntObserver());

        Observable.just(1, 2, 3, 4, 5, 6)
                .lastOrDefault(2).subscribe(ObserverFactory.createIntObserver());

    }

    @Test
    public void sampleTest(){

    }


    /**
     * 跳过几个
     */
    @Test
    public void skipTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .skip(2).subscribe(ObserverFactory.createIntObserver());

    }


    /**
     * 跳过后面几个
     */
    @Test
    public void skipLastTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .skipLast(2).subscribe(ObserverFactory.createIntObserver());

    }

    /**
     * 获取几个元素
     */
    @Test
    public void takeTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .take(2).subscribe(ObserverFactory.createIntObserver());

    }

    /**
     * 抓取后面几个元素
     */
    @Test
    public void takeLastTest(){
        Observable.just(1, 2, 3, 4, 5, 6)
                .takeLast(2).subscribe(ObserverFactory.createIntObserver());

    }


}

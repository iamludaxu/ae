package gift.witch.android.ae.rxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public class RxJavaCreateTest {

    @Test
    public void testCreate() {

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Observable Create call");
                subscriber.onCompleted();
            }
        });

        observable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testDefer() {
        Observable deferObservable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            //注意此处的call方法没有Subscriber参数
            public Observable<String> call() {
                System.out.println("Observable defer call");
                return Observable.just("deferObservable");
            }
        });
        deferObservable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testEmpty() {
        Observable deferObservable = Observable.empty();
        deferObservable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testNever() {
        Observable deferObservable = Observable.never();
        deferObservable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testThrow() {
        Observable deferObservable = Observable.error(new Throwable());
        deferObservable.subscribe(ObserverFactory.createObserver());
    }

    /**
     * 使用from( )，遍历集合，发送每个item
     */
    @Test
    public void testFrom(){
        List<String> list = new ArrayList<>();
        list.add("from1");
        list.add("from2");
        list.add("from3");
        Observable fromObservable = Observable.from(list);  //遍历list 每次发送一个
        fromObservable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testInterval(){

        /**
         * 在测试中会报错，在android程序中不会
         */
        Observable intervalObservable = Observable.interval(2,1, TimeUnit.SECONDS).subscribeOn(Schedulers.io());//每隔一秒发送一次
        intervalObservable.subscribe(ObserverFactory.createObserver());

    }

    /**
     * 使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据
     */
    @Test
    public void testJust() {

        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
        justObservable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testRang(){

        Observable rangeObservable = Observable.range(10, 5);//将发送整数10，11，12，13，14
        rangeObservable.subscribe(ObserverFactory.createIntObserver());
    }

    @Test
    public void testRepeat(){
        Observable repeatObservable = Observable.just("repeatObservable").repeat(3);//重复发射3次
        repeatObservable.subscribe(ObserverFactory.createObserver());
    }


    /**
     * 没有这个方法
     */
    @Test
    public void testStart(){
        //Observable.fromCallable();
    }


    @Test
    public void testTimer(){

        /**
         * 在测试中会报错，在android程序中不会
         */
        Observable timeObservable = Observable.just("repeatObservable").timer(5, TimeUnit.SECONDS);  //3秒后发射一个
        timeObservable.subscribe(ObserverFactory.createObserver());
    }


}

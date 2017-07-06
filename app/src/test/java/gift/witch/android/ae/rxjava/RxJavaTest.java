package gift.witch.android.ae.rxjava;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public class RxJavaTest {

    @Test
    public void testPrimitives() {

        /**
         * 创建一个被观察者
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hi，Weavey！");  //发送数据"Hi，Weavey！"
                subscriber.onCompleted();
            }
        });


        /**
         * 创建一个观察者
         */
        Observer<String> observer2 = new Observer<String>() {

            @Override
            public void onCompleted() {
                //数据接收完成时调用
                System.out.println("observer2 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observer2 onError");
                //发生错误调用
            }

            @Override
            public void onNext(String s) {
                //正常接收数据调用
                System.out.println("observer2 "+ s);
            }
        };
        /**
         * 创建一个观察者
         */
        Observer<String> observer1 = new Observer<String>() {

            @Override
            public void onCompleted() {
                //数据接收完成时调用
                System.out.println("observer1 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observer1 onError");
                //发生错误调用
            }

            @Override
            public void onNext(String s) {
                //正常接收数据调用
                System.out.println("observer1 "+s);
            }
        };

        Subscriber subscriber =  new Subscriber<String>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        subscriber.unsubscribe();
        /**
         * subscribe订阅认购
         */
        observable.subscribe(observer2);
        observable.subscribe(observer1);
    }


    @Test
    public void testPrimitives2() {

        /**
         * 创建一个被观察者
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("OnSubscribe call");
                subscriber.onCompleted();
            }
        });

        /**
         * 创建一个观察者
         */
        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {
                //数据接收完成时调用
                System.out.println("observer1 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observer1 onError");
                //发生错误调用
            }

            @Override
            public void onNext(String s) {
                //正常接收数据调用
                System.out.println("observer1 "+s);
            }
        };

        /**
         * subscribe订阅认购
         */
        observable.subscribe(observer);

    }


    /**
     * 使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据
     */
    @Test
    public void testJust() {

        Observable justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"

        justObservable.subscribe(createObserver());
    }


    @Test
    public void testDefer(){
        Observable deferObservable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            //注意此处的call方法没有Subscriber参数
            public Observable<String> call() {
                System.out.println("Observable defer call");
                return Observable.just("deferObservable");
            }});
        deferObservable.subscribe(createObserver());
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
        fromObservable.subscribe(createObserver());
    }

    @Test
    public void testInterval(){

        Observable intervalObservable = Observable.interval(2,1, TimeUnit.SECONDS).subscribeOn(Schedulers.io());//每隔一秒发送一次
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


    @Test
    public void testRang(){
        Observable rangeObservable = Observable.range(10, 5);//将发送整数10，11，12，13，14
        rangeObservable.subscribe(createIntObserver());
    }

    @Test
    public void testTime(){
        Observable timeObservable = Observable.just("repeatObservable").timer(5, TimeUnit.SECONDS);  //3秒后发射一个
        timeObservable.subscribe(createObserver());
    }

    @Test
    public void testRepeat(){
        Observable repeatObservable = Observable.just("repeatObservable").repeat(3);//重复发射3次
        repeatObservable.subscribe(createObserver());
    }


    @Test
    public void test(){
        Observable.interval(1L, TimeUnit.MILLISECONDS)
                //.subscribeOn(Schedulers.newThread())
                //将观察者的工作放在新线程环境中
                .observeOn(Schedulers.newThread())
                //观察者处理每1000ms才处理一个事件
                .subscribe(new Action1() {
                    @Override
                    public void call(Object o) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.w("TAG","---->"+o);
                    }

                });
    }

    private Observer createObserver(){
        /**
         * 创建一个观察者
         */
        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {
                //数据接收完成时调用
                System.out.println("observer1 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observer1 onError");
                //发生错误调用
            }

            @Override
            public void onNext(String s) {
                //正常接收数据调用
                System.out.println("observer1 "+s);
            }
        };

        return observer;
    }

    private Observer createIntObserver(){
        /**
         * 创建一个观察者
         */
        Observer<Integer> observer = new Observer<Integer>() {

            @Override
            public void onCompleted() {
                //数据接收完成时调用
                System.out.println("observer1 onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("observer1 onError");
                //发生错误调用
            }

            @Override
            public void onNext(Integer s) {
                //正常接收数据调用
                System.out.println("observer1 "+s);
            }
        };

        return observer;
    }




}

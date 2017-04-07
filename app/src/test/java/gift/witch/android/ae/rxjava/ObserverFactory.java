package gift.witch.android.ae.rxjava;

import java.util.List;

import gift.witch.android.ae.rxjava.data.Child;
import gift.witch.android.ae.rxjava.data.Parent;
import rx.Observable;
import rx.Observer;

public class ObserverFactory {

    public static Observer createObserver() {
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
                System.out.println("observer1 onNext");
                System.out.println("observer1 " + s);
            }
        };

        return observer;
    }

    public static Observer createIntObserver() {
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
                System.out.println("observer1 onNext");
                System.out.println("observer1 " + s);
            }
        };

        return observer;
    }

    public static Observer<List<String>> createListObserver() {
        /**
         * 创建一个观察者
         */
        Observer<List<String>> observer = new Observer<List<String>>() {

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
            public void onNext(List<String> s) {
                //正常接收数据调用
                System.out.println("observer1 onNext");
                for (String ss : s) {
                    System.out.println("observer1 " + ss);
                }

            }
        };

        return observer;
    }
    public static Observer<Child> createObjectObserver() {
        /**
         * 创建一个观察者
         */
        Observer<Child> observer = new Observer<Child>() {

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
            public void onNext(Child s) {
                //正常接收数据调用
                System.out.println("observer1 onNext");
                System.out.println("observer1 child name:" + s.getName());

            }
        };

        return observer;
    }

    public static Observer<Parent> createParentObjectObserver() {
        /**
         * 创建一个观察者
         */
        Observer<Parent> observer = new Observer<Parent>() {

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
            public void onNext(Parent s) {
                //正常接收数据调用
                System.out.println("observer1 onNext");
                System.out.println("observer1 child name:" + s.getName());

            }
        };

        return observer;
    }

    public static Observer<Observable<String>> createObservableObjectObserver() {
        /**
         * 创建一个观察者
         */
        Observer<Observable<String>> observer = new Observer<Observable<String>>() {

            @Override
            public void onCompleted() {
                //数据接收完成时调用
                System.out.println("outline  onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("outline onError");
                //发生错误调用
            }

            @Override
            public void onNext(Observable<String> s) {
                //正常接收数据调用
                System.out.println("outline onNext");
                s.subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("inline onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("inline onError");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("inline s:"+s);
                    }
                });
            }
        };

        return observer;
    }
}

package gift.witch.android.ae.rxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gift.witch.android.ae.rxjava.data.Child;
import gift.witch.android.ae.rxjava.data.Parent;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public class RxJavaTransformTest {


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
    public void testBuffer() {
        Observable rangeObservable = Observable.from(list).buffer(3);
        rangeObservable.subscribe(ObserverFactory.createListObserver());
    }

    @Test
    public void testFlatMap() {

        Parent school = new Parent();
        school.getChildList().add(new Child("Child1"));
        school.getChildList().add(new Child("Child2"));
        school.getChildList().add(new Child("Child3"));


        Observable rangeObservable = Observable.just(school).flatMap(new Func1<Parent, Observable<?>>() {
            @Override
            public Observable<Child> call(Parent parent) {
                return Observable.from(parent.getChildList());
            }
        });
        rangeObservable.subscribe(ObserverFactory.createObjectObserver());
    }

    @Test
    public void testGroupBy() {
        Parent parent1 = new Parent();
        parent1.setName("A1");
        Parent parent2 = new Parent();
        parent2.setName("C3");
        Parent parent3 = new Parent();
        parent3.setName("A3");
        Parent parent4 = new Parent();
        parent4.setName("C1");
        Parent parent5 = new Parent();
        parent5.setName("B1");


        Observable rangeObservable = Observable.just(parent1, parent2, parent3, parent4, parent5).groupBy(new Func1<Parent, String>() {
            @Override
            public String call(Parent parent) {
                return parent.getName().substring(0, 1);
            }
        });
        rangeObservable.subscribe(ObserverFactory.createObjectObserver());
    }

    @Test
    public void testMap() {
        Observable observable = Observable.from(list).map(new Func1<String, String>() {
            @Override
            public String call(String string) {
                return string + " map";
            }
        });
        observable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testScan() {
        Observable observable = Observable.from(list).scan(new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + " > " + s2;
            }
        });
        observable.subscribe(ObserverFactory.createObserver());
    }

    @Test
    public void testWindow(){
        Observable observable = Observable.from(list).window(3);
        observable.subscribe(ObserverFactory.createObservableObjectObserver());
    }

}

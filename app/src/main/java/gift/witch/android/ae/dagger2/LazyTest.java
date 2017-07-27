package gift.witch.android.ae.dagger2;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

public class LazyTest {

    @Inject
    Lazy<TestData> mLazy_TestData;

    @Inject
    Provider<TestData> mProvides_TestData;

    public LazyTest(){
        DaggerLazyComponent.builder().lzayModule(new LzayModule()).build().inject(this);
    }


    public void print(){

        Logger.i("TestData one:"+mLazy_TestData.get().toString());//TestData one:gift.witch.android.ae.dagger2.TestData@423ab570
        Logger.i("TestData two:"+mLazy_TestData.get().toString());//TestData two:gift.witch.android.ae.dagger2.TestData@423ab570
        Logger.i("TestData one:"+mProvides_TestData.get().toString());//TestData one:gift.witch.android.ae.dagger2.TestData@423af620
        Logger.i("TestData two:"+mProvides_TestData.get().toString());//TestData two:gift.witch.android.ae.dagger2.TestData@423b1628

    }

}

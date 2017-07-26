package gift.witch.android.ae.dagger2;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * 单例目标类
 */
public class SingleTest {

    @Inject
    TestData mTestData1;

    @Inject
    TestData mTestData2;


    SingleTest(){
        DaggerSingletonComponent.builder().singleModule(new SingleModule()).build().inject(this);
    }

    public void print(){
        Logger.i(mTestData1.toString());
        Logger.i(mTestData2.toString());
        Logger.i(mTestData1.getName());
        Logger.i(mTestData2.getName());
    }

}

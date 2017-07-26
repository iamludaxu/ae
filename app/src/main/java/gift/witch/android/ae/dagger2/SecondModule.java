package gift.witch.android.ae.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * 第二个Module
 */
@Module
public class SecondModule {


    private TestData mTestData;

    public SecondModule(){
        mTestData = new TestData("new SecondModule().TestData()");
    }

    /**
     * 提供TestData对象
     * @return
     */
    @Provides
    TestData providesTestData(){
        return mTestData;
    }

}

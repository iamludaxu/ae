package gift.witch.android.ae.dagger2;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

public class CustomTest {

    @Inject
    TestData mTestData;


    public CustomTest(){
        DaggerCustomComponent.builder().customModule(new CustomModule("CustomTest NAME")).build().inject(this);
    }

    public void print(){
        Logger.i(mTestData.toString());
    }
}

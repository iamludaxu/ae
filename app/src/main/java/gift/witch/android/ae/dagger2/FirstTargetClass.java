package gift.witch.android.ae.dagger2;

import javax.inject.Inject;

/**
 *
 * 目标类，需要注入各种对象
 *
 */
public class FirstTargetClass {

    private InjectConstructionData mInjectConstructionData;

    @Inject
    InjectPropertyData mInjectPropertyData;

    @Inject
    TestData mTestData;

    private InjectMethodData mInjectMethodData;

    @Inject
    public FirstTargetClass(InjectConstructionData injectConstructionData){
        mInjectConstructionData = injectConstructionData;
    }

    @Inject
    public void set(InjectMethodData injectMethodData){
        mInjectMethodData = injectMethodData;
    }


    public InjectConstructionData getInjectConstructionData(){
        return mInjectConstructionData;
    }

}

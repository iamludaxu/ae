package gift.witch.android.ae.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 第一个Module
 */
@Module
public class FirstModule {

    private String mName;

    public FirstModule(String name){
        mName = name;
    }

    /**
     * 提供String对象
     * @return
     */
    @Provides
    public String provideName(){
        return mName;
    }

    /**
     * 提供InjectMethodData对象
     * @return
     */
    @Provides
    public InjectMethodData provideInjectMemberData(){
        return new InjectMethodData();
    }

    /**
     * 提供InjectConstructionData对象
     * @return
     */
    @Provides
    public InjectConstructionData provideInjectConstructionData(){
        return new InjectConstructionData();
    }

    /**
     * 提供InjectPropertyData对象
     * @return
     */
    @Provides
    public InjectPropertyData provideInjectPropertyData(){
        return new InjectPropertyData();
    }
}

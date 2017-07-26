package gift.witch.android.ae.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SingleModule {

    private int i = 0;

    public SingleModule(){
    }

    @Singleton
    @Provides
    TestData provideSingleTestData(){
        i++;
        return new TestData("name"+i);
    }
}

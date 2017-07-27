package gift.witch.android.ae.dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class LzayModule {

    @Provides
    public TestData provideTestData(){
        return new TestData("LzayModule TestData");
    }

}

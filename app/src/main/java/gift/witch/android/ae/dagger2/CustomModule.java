package gift.witch.android.ae.dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class CustomModule {

    private TestData mTestData;

    public CustomModule(String name) {
        mTestData = new TestData(name);
    }

    @CustomScope
    @Provides
    public TestData provideTestData() {
        return mTestData;
    }
}

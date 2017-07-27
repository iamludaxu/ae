package gift.witch.android.ae.dagger2;

import dagger.Module;
import dagger.Provides;

@Module
public class QualifierModule {

    @QualifierType("A")
    @Provides
    TestData provideA(){
        return new TestData("A");
    }

    @QualifierType("B")
    @Provides
    TestData provideB(){
        return new TestData("B");
    }

}

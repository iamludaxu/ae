package gift.witch.android.ae.dagger2;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

public class QualifierTest {

    @QualifierType("A")
    @Inject
    TestData mTestDataA;

    @QualifierType("B")
    @Inject
    TestData mTestDataB;

    public QualifierTest(){
        QualifierComponent component = DaggerQualifierComponent.builder().qualifierModule(new QualifierModule()).build();
        component.inject(this);
        TestData testDataA = component.provideA();
        TestData testDataB = component.provideB();

    }

    public void print(){
        Logger.i("TestDataA："+mTestDataA.getName());
        Logger.i("TestDataB："+mTestDataB.getName());
    }

}

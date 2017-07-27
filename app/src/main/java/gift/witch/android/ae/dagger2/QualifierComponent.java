package gift.witch.android.ae.dagger2;

import javax.inject.Named;

import dagger.Component;

@Component(modules = QualifierModule.class)
public interface QualifierComponent {

    void inject(QualifierTest qualifierTest);

    @QualifierType("A")
    TestData provideA();


    @QualifierType("B")
    TestData provideB();

}

package gift.witch.android.ae.dagger2;

import android.os.Bundle;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;


public class Dagger2Activity extends BaseCompatActivity {

    @Inject
    FirstTargetClass mFirstTargetClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);

        DaggerFirstComponent.builder()
                .firstModule(new FirstModule("name"))
                .secondModule(new SecondModule())
                .build()
                .inject(this);


        SingleTest singleTest = new SingleTest();
        singleTest.print();

        Logger.i("================================");
        CustomTest customTest = new CustomTest();
        customTest.print();//gift.witch.android.ae.dagger2.TestData@42353bc8

        CustomOtherTest customOtherTest = new CustomOtherTest();
        customOtherTest.print();//gift.witch.android.ae.dagger2.TestData@423567b8

        QualifierTest qualifierTest = new QualifierTest();
        qualifierTest.print();//TestDataA：A  TestDataB：B

        LazyTest lazyTest = new LazyTest();
        lazyTest.print();

        CustomModule_ProvideTestDataFactory.create(new CustomModule()).;
    }

}

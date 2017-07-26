package gift.witch.android.ae.dagger2;

import android.os.Bundle;

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

    }

}

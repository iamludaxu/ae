package gift.witch.android.ae.dagger2;

import dagger.Component;

/**
 * Dagger2中的Component向Dagger2Activity中的类注入对象实例
 */
@Component(modules = {FirstModule.class,SecondModule.class})
public interface FirstComponent {

    void inject(Dagger2Activity activity);

    TestData provideTestData();
}

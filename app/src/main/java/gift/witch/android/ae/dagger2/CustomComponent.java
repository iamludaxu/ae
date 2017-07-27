package gift.witch.android.ae.dagger2;

import dagger.Component;

@CustomScope
@Component(modules = CustomModule.class)
public interface CustomComponent {

    void inject(CustomTest customTest);

    void inject(CustomOtherTest customOtherTest);

}

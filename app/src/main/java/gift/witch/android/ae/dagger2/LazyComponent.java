package gift.witch.android.ae.dagger2;

import dagger.Component;

@Component(modules = LzayModule.class)
public interface LazyComponent {

    void inject(LazyTest lazyTest);

}

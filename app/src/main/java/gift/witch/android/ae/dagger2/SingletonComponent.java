package gift.witch.android.ae.dagger2;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SingleModule.class)
public interface SingletonComponent {

    void inject(SingleTest singleTest);
}

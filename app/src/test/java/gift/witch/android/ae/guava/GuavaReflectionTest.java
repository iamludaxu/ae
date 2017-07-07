package gift.witch.android.ae.guava;


import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;

/**
 */
public class GuavaReflectionTest {


    @Test
    public void reflectionTest() {
        TypeToken<String> stringTypeToken = TypeToken.of(String.class);
        Type type = stringTypeToken.getType();
        TypeToken.TypeSet typeSet = stringTypeToken.getTypes();
        boolean isArray = stringTypeToken.isArray();
        stringTypeToken.getComponentType();
        TypeToken<? super String> supertype = stringTypeToken.getSupertype(Object.class);
        TypeToken<? extends String> subtype = stringTypeToken.getSubtype(Object.class);

        Class<? super String> stringClass = stringTypeToken.getRawType();
        try {
            stringTypeToken.constructor(String.class.getConstructor(null));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Invokable invokable = Invokable.from(String.class.getConstructor(null));
            invokable.isPublic();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


}

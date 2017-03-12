package gift.witch.android.ae.gson;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * User: Geek_Soledad(msdx.android@qq.com)
 * Date: 2017-03-10
 * Time: 14:02
 * FIXME
 */
public class MyInstanceCreator implements InstanceCreator<MyClass> {


    @Override
    public MyClass createInstance(Type type) {
        return new MyClass();
    }

}

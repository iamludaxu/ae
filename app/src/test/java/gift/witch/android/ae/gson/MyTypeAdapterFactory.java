package gift.witch.android.ae.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * User: Geek_Soledad(msdx.android@qq.com)
 * Date: 2017-03-10
 * Time: 15:37
 * FIXME
 */
public class MyTypeAdapterFactory implements TypeAdapterFactory {


    private Class<?> type;

    @Override
    public <T> TypeAdapter<T> create(Gson gson,TypeToken<T> typeToken) {
        return typeToken.getRawType() == type ? (TypeAdapter<T>) new MyTypeAdapter() : null;
    }



}

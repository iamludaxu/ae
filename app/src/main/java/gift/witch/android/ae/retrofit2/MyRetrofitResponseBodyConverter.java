package gift.witch.android.ae.retrofit2;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 将返回的数据转成成Call<T>中的T
 */
public class MyRetrofitResponseBodyConverter implements Converter<ResponseBody,MyRetrofitObject> {

    @Override
    public MyRetrofitObject convert(ResponseBody value) throws IOException {
        MyRetrofitObject retrofitObject = new MyRetrofitObject();
        retrofitObject.setAnInt(12);
        retrofitObject.setString("string");
        return retrofitObject;
    }

}

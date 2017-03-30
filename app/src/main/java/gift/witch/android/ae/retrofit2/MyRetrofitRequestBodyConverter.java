package gift.witch.android.ae.retrofit2;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * 对自定义请求转换
 */
public class MyRetrofitRequestBodyConverter implements Converter<MyRetrofitObject, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("自定义头; charset=UTF-8");

    @Override
    public RequestBody convert(MyRetrofitObject value) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("自定义body:int");
        stringBuilder.append(value.getAnInt());
        stringBuilder.append("====String:");
        stringBuilder.append(value.getString());
        //创建请求数据
        return RequestBody.create(MEDIA_TYPE,stringBuilder.toString());
    }
}

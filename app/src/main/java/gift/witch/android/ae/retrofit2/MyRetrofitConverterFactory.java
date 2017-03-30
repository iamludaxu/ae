package gift.witch.android.ae.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 *
 * 用于向Retrofit提供相应Converter的工厂
 *
 */
public class MyRetrofitConverterFactory extends Converter.Factory {

    public static MyRetrofitConverterFactory create() {
        return new MyRetrofitConverterFactory();
    }

    private MyRetrofitConverterFactory() {
    }


    // 在这里创建 从自定类型到ResponseBody 的Converter,不能处理就返回null，
    // 主要用于对Part、PartMap、Body注解的处理
    @Override
    public Converter<MyRetrofitObject, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new MyRetrofitRequestBodyConverter();
    }


    // 这里创建从ResponseBody其它类型的Converter，如果不能处理返回null
    // 主要用于对响应体的处理
    @Override
    public Converter<ResponseBody, MyRetrofitObject> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if(type == MyRetrofitObject.class){
            return new MyRetrofitResponseBodyConverter();
        }
        return null;
    }
}

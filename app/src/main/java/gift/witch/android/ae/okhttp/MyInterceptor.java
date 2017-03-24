package gift.witch.android.ae.okhttp;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 应用拦截器
 */
public class MyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Logger.i(String.format("MyInterceptor Send request Url: %s",
                request.url()));

        Response response = chain.proceed(request);

        Logger.i(String.format("MyInterceptor Received response length: %s ", response.body().contentLength()));

        return response;
    }
}

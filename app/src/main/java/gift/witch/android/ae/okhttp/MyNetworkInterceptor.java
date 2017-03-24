package gift.witch.android.ae.okhttp;

import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 网络拦截器
 */
public class MyNetworkInterceptor implements Interceptor {


    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        Logger.i(String.format("MyNetworkInterceptor Send request for %s %n%s",
                request.url(), request.headers()));

        long t1 = System.nanoTime();

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();

        Logger.i(String.format("MyNetworkInterceptor Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}

package gift.witch.android.ae.okhttp;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;


/**
 * 数据源
 * <p/>
 * http://www.avatardata.cn/Docs/Api/d7afb872-fa95-48b5-9af8-39c5afd4dcd9
 * <p/>
 * 参考https://github.com/square/okhttp/wiki/Recipes
 */
public class OkHttpExample {

    private OkHttpClient mClient;

    public OkHttpExample() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        /**
         * 设置读写超时和连接超时
         */
        builder.connectTimeout(10_000, TimeUnit.MILLISECONDS);
        builder.readTimeout(10_000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(10_000, TimeUnit.MILLISECONDS);
        /**
         * 默认是重定向
         */
        builder.followRedirects(true);
        /**
         * 应用拦截器
         */
        builder.addInterceptor(new MyInterceptor());
        /**
         * 网络拦截器
         */
        builder.addNetworkInterceptor(new MyNetworkInterceptor());

        /**
         *
         */
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(""), cacheSize);
        builder.cache(cache);

        mClient = builder.build();

    }


    /**
     * 异步发送请求
     */
    public void asynchronousGetTest(){
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });
    }

    /**
     * 同步发送请求
     */
    public void synchronousGetTest(){
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        Call call = mClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void test0(){
        Request.Builder builder = new Request.Builder();
        /**
         * 请求地址
         * builder.url(String url);
         * builder.url(URL url);
         * builder.url(HttpUrl url);
         */
        builder.url("http://www.baidu.com");
        /**
         * 头文件操作
         */
        builder.header("User-Agent", "OkHttp Headers.java");
        builder.addHeader("Accept", "application/json; q=0.5");
        /**
         * 对缓存的处理
         */
        builder.cacheControl(CacheControl.FORCE_NETWORK);
        /**
         *
         * 请求方式
         *
         * builder.get()
         * builder.head();
         * builder.post();
         * builder.put();
         * builder.patch();
         * builder.delete();
         *
         */
        builder.get();

    }

    public Call test1() {

        /**
         * 单独设置httpClient
         */
        OkHttpClient copy = mClient.newBuilder()
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url("http://api.avatardata.cn/Cook/CookClass?key=220c180bb20f40dabd03e54adc9f9595&id=10")
                /**
                 * 控制缓存
                 */
                //.cacheControl(CacheControl.FORCE_NETWORK)
                /**
                 * 头文件操作
                 */
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                //.removeHeader("Accept")
                .build();

        Call call = copy.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });

        return  call;
    }


    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");

    /**
     * 发送字符串
     */
    public void postStringTest() {
        String postBody = ""
                + "Releases\n"
                + "--------\n"
                + "\n"
                + " * _1.0_ May 6, 2013\n"
                + " * _1.1_ June 15, 2013\n"
                + " * _1.2_ August 11, 2013\n";

        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_MARKDOWN,postBody);

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });
    }


    /**
     * 发送数据流
     */
    public void postStream(){

        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_TYPE_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("Numbers\n");
                sink.writeUtf8("-------\n");
                for (int i = 2; i <= 997; i++) {
                    sink.writeUtf8(String.format(" * %s = %s\n", i, factor(i)));
                }
            }
        };

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });


    }

    private String factor(int n) {
        for (int i = 2; i < n; i++) {
            int x = n / i;
            if (x * i == n) return factor(x) + " × " + i;
        }
        return Integer.toString(n);
    }


    /**
     * 上传文件
     */
    public void postFile(){

        File file = new File("文件路径");
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_MARKDOWN,file);

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });

    }

    /**
     * 发送表单请求
     */
    public void postForm(){

        RequestBody formBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .build();


        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(formBody)
                .build();

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });

    }


    /**
     * MultipartBody 请求
     */
    public void postMultipartBody() {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "Square Logo")
                .addFormDataPart("image", "logo-square.png",
                        RequestBody.create(MEDIA_TYPE_PNG, new File("website/static/logo-square.png")))
                .build();

        Request request = new Request.Builder()
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();

        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.i(response.body().string());
            }
        });
    }


}

package gift.witch.android.ae.retrofit2;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManage {

    private Retrofit mRetrofit;
    private GitHubService mService;

    public RetrofitManage(){

        Retrofit.Builder builder = new Retrofit.Builder();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        /**
         * 对OkHttp进行设置
         */
        builder.client(okHttpClient);
        /**
         * 自定义转换
         */
        builder.addConverterFactory(MyRetrofitConverterFactory.create());
        /**
         * 根目录，需要
         */
        builder.baseUrl("https://api.github.com/");
        /**
         *增加返回方式
         */
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        /**
         * 增加转换器
         */
        builder.addConverterFactory(GsonConverterFactory.create());
        /**
         * 检测 mRetrofit.create(GitHubService.class)
         */
        builder.validateEagerly(true);
        /**
         * 自定义Executor
         */
        //builder.callbackExecutor()
        /**
         * 设置okhttp.Call.Factory
         */
        //builder.callFactory()

        mRetrofit = builder.build();

        mService = mRetrofit.create(GitHubService.class);

    }

    public void test(){
        Call<String> repos = mService.test0();
    }


    public void conerter(){
        MyRetrofitObject myRetrofitObject = new MyRetrofitObject();
        myRetrofitObject.setAnInt(9);
        myRetrofitObject.setString("哈哈");
        Call<String> repos = mService.conerter0(myRetrofitObject);
    }

    public void error1(){
        mService.error1("fff");
    }
}

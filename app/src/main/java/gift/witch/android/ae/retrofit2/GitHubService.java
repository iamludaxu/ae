package gift.witch.android.ae.retrofit2;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface GitHubService {


    @GET()
    Call<String> error1(
            @Url String url);

    /**
     * http请求方式
     *
     * @DELETE
     * @GET
     * @HEAD
     * @PATCH
     * @POST
     * @PUT
     * @OPTIONS
     * @HTTP(method = "DELETE", path = "remove/", hasBody = true)
     */
    @POST("users/{user}/repos")
    /**
     * 增加固定头文件
     */
    @Headers({"AA:pp", "BB:oo"})
    /**
     * 模拟表单方式,两者取其一
     * @Multipart()
     * @FormUrlEncoded()
     */
    //@FormUrlEncoded()
    @Streaming
    Call<String> test0();


    /**
     * @Path() 路径中的自定参数
     * @Query() 查询参数
     * @QuerMap 查询参数MAP表，必须是map类型
     * @QueryName 查询参数
     * @Header() 增加不固定的头信息
     */
    @GET("group/{id}/users")
    Call<String> test1(
            @Path("id") int groupId,
            @Query("sort") String sort,
            @QueryMap Map<String, String> options,
            @Header("username") String username,
            @QueryName String queryName,
            @HeaderMap Map<String, String> headers);

    @GET("group/{id}/users")
    Call<String> test0(@Path("id") int id);


    /**
     * @Field和@FieldMap 只有在@FormUrlEncoded中才能使用
     */
    @FormUrlEncoded
    @POST("group/{id}/users")
    Call<String> test2(
            @Field("field") String field,
            @FieldMap Map<String, String> fields
    );

    /**
     * @Part和@PartMap 只有在@Multipart中才能使用
     */
    @Multipart

    @POST("group/users")
    Call<String> test3(
            @Part("part") String part,
            @PartMap Map<String, String> parts
    );


    /**
     * 使用@Body时 不能为@Multipart或@FormUrlEncoded
     */
    RequestBody body = RequestBody.create(MediaType.parse("text/plain"), "hi");

    @POST("group/users")
    Call<String> test4(
            @Body RequestBody body
    );

    @POST("group/users")
    Call<String> conerter0(
            @Body MyRetrofitObject body
    );



}

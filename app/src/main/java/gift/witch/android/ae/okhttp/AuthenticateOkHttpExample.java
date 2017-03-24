package gift.witch.android.ae.okhttp;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


/**
 *
 * okhttp验证的问题
 *
 */
public class AuthenticateOkHttpExample {

    private OkHttpClient mClient;

    public AuthenticateOkHttpExample(){
        mClient = new OkHttpClient.Builder().authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {

                System.out.println("Authenticating for response: " + response);
                System.out.println("Challenges: " + response.challenges());
                String credential = Credentials.basic("jesse", "password1");

                return response.request().newBuilder()
                        .header("Authorization", credential)
                        .build();
            }
        }).build();
    }

    public void testAuthenticate(){
        Request request = new Request.Builder()
                .url("http://publicobject.com/secrets/hellosecret.txt")
                .build();

        Response response = null;
        try {
            response = mClient.newCall(request).execute();

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

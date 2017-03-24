package gift.witch.android.ae.base;

import android.app.Application;

import com.orhanobut.logger.Logger;

public class BaseApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        setConfig();
    }

    private void setConfig(){

        Logger.init().methodCount(0).hideThreadInfo();

    }

}

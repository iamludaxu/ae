package gift.witch.android.ae.logger;

import android.os.Bundle;
import android.view.View;

import com.orhanobut.logger.Logger;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

/**
 *
 * Logger
 *
 * https://iamludaxu.gitbooks.io/android/content/logger.html
 *
 */
public class LoggerActivity extends BaseCompatActivity implements View.OnClickListener {


    private String TAG = "LoggerActivity";
    private int mMethodCount = 2;
    private int mOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        /**
         * 打印日志
         */
        findViewById(R.id.print).setOnClickListener(this);
        /**
         * 重置
         */
        findViewById(R.id.reset).setOnClickListener(this);
        /**
         * 减少方法数
         */
        findViewById(R.id.reduce).setOnClickListener(this);
        /**
         * 隐藏线程信息
         */
        findViewById(R.id.hide_thread_info).setOnClickListener(this);
        /**
         * 初始化
         */
        Logger.init().methodCount(mMethodCount).methodOffset(mOffset);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if(vId == R.id.print){
            Logger.v("Verbose");
            Logger.d("Debug");
            Logger.i("Info");
            Logger.w("Warn");
            Logger.e("Error");
            Logger.wtf("Wtf");
            String JSON_CONTENT = "[{\"key\":3}]";
            Logger.json(JSON_CONTENT);
            String XML_CONTENT = "<?xml version=\"1.0\"?>\n" +
                    "<note>\n" +
                    "<body>Don't forget me this weekend!</body>\n" +
                    "</note>";
            Logger.xml(XML_CONTENT);
            Logger.t(TAG).d("增加了tag标签");

            //Logger.log(DEBUG, "tag", "message", throwable);
        }else if(vId == R.id.reset){
            Logger.init().reset();
        }else if(vId == R.id.hide_thread_info){
            Logger.init().hideThreadInfo();
        }else if(vId == R.id.reduce){
            Logger.init().methodCount(--mMethodCount);
        }

    }
}

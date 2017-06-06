package gift.witch.android.ae.message;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.orhanobut.logger.Logger;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;


/**
 *
 * https://iamludaxu.gitbooks.io/android/content/xiao-xi-chu-li-ji-zhi.html
 *
 */
public class MessageActivity extends BaseCompatActivity implements View.OnClickListener {


    private String TAG = "MessageActivity";

    private LooperThread mLooperThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);

        mLooperThread = new LooperThread();
        mLooperThread.start();
    }


    @Override
    public void onClick(View v) {
        int vId = v.getId();
        if (vId == R.id.btn1) {
            testMessage();
        } else if (vId == R.id.btn2) {
            mLooperThread.mHandler.sendEmptyMessage(0);
        } else if(vId == R.id.btn3){
            sendMessageFromHandler();
        } else if(vId == R.id.btn4){
            sendMessageToRunable();
        }
    }


    /**
     * 普通的发送消息
     */
    private void testMessage() {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Logger.i("消息接收");
            }
        };
        Logger.i("消息开始发送");
        Message.obtain(handler).sendToTarget();
    }

    /**
     * 用Handler发起消息
     */
    private void sendMessageFromHandler() {
        Handler handler = new Handler(

                /**
                 * 如果这里返回true，说明消息已经被消费掉
                 */
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        boolean result = true;
                        Logger.i("返回" + result + " 被Callback消费掉");
                        return result;
                    }
                }
        ) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Logger.i("Handler中的方法handleMessage");
            }
        };
        handler.sendEmptyMessage(0);
    }

    /**
     * Runable运行
     */
    private void sendMessageToRunable(){
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        /**
         * 和Thread中的Runnable不一样，这里的Runable只是执行代码而已
         */
        Message.obtain(handler, new Runnable() {
            @Override
            public void run() {
                Logger.i("调用Message中的Runnable");
            }
        }).sendToTarget();

        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    class LooperThread extends Thread {

        public LooperThread() {
            super("LooperThread");
        }

        public Handler mHandler;

        public void run() {
            Looper.prepare();

            mHandler = new Handler() {
                public void handleMessage(Message msg) {
                    // process incoming messages here
                    String name = Looper.myLooper().getThread().getName();
                    Logger.i("Thread Name:" + name + " 消息接收");
                }
            };

            Looper.loop();
        }

    }






}

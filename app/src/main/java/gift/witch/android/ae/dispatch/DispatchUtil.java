package gift.witch.android.ae.dispatch;

import android.view.MotionEvent;

import com.orhanobut.logger.Logger;

public class DispatchUtil {

    public static void print(String tag,String method ,MotionEvent event){

        String action = "";
        if(MotionEvent.ACTION_UP == event.getAction()){
            action = "up";
        }else if(MotionEvent.ACTION_MOVE == event.getAction()){
            action = "move";
        }else if(MotionEvent.ACTION_DOWN == event.getAction()){
            action = "down";
        }

        Logger.i("tag:"+tag+"    method:"+method+"    action:"+action+"    [x:"+event.getX()+"  y:" +event.getY()+"]");

    }
}

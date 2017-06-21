package gift.witch.android.ae;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboSharedPreferences;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.ShadowToast;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;
import org.robolectric.util.ActivityController;
import org.robolectric.util.ServiceController;

import java.net.URISyntaxException;

import gift.witch.android.ae.test.NextRobolectricActivity;
import gift.witch.android.ae.test.RobolectricActivity;
import gift.witch.android.ae.test.RobolectricFragment;
import gift.witch.android.ae.test.RobolectricIntentService;
import gift.witch.android.ae.test.RobolectricReceiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(MyRobolectricTestRunner.class)
@Config(manifest = "./src/main/AndroidManifest.xml",sdk = 23)
public class RobolectricActivityTest {

    @Before
    public void setUp() throws URISyntaxException {
        //输出日志
        ShadowLog.stream = System.out;
    }

    /**
     * 测试activity实例
     */
    @Test
    public void testMainActivity() {
        RobolectricActivity mainActivity = Robolectric.setupActivity(RobolectricActivity.class);
        assertNotNull(mainActivity);
        assertEquals(mainActivity.getTitle(), "RobolectricActivity");


        mainActivity.findViewById(R.id.btn).performClick();
        Intent expectedIntent = new Intent(mainActivity, NextRobolectricActivity.class);
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();

        assertEquals(expectedIntent, actualIntent);

        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());

    }


    /**
     * 测试生命周期
     */
    @Test
    public void testLifecycle() {
        ActivityController<RobolectricActivity> activityController = Robolectric.buildActivity(RobolectricActivity.class).create();
        Activity activity = activityController.get();
        TextView textview = (TextView) activity.findViewById(R.id.text);
        assertEquals("onCreate",textview.getText().toString());
        activityController.resume();
        assertEquals("onResume", textview.getText().toString());
        activityController.destroy();
        assertEquals("onDestroy", textview.getText().toString());
    }

    /**
     * 测试跳转
     */
    @Test
    public void testStartActivity() {
        RobolectricActivity mainActivity = Robolectric.setupActivity(RobolectricActivity.class);

        mainActivity.findViewById(R.id.btn).performClick();
        Intent expectedIntent = new Intent(mainActivity, NextRobolectricActivity.class);
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();

        /**
         * 无法通过
         * 可以使用assertj-android断言
         * https://github.com/square/assertj-android
         */
        //assertEquals(expectedIntent, actualIntent);

        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());

    }

    /**
     * 测试UI状态
     */
    @Test
    public void testViewState(){
        RobolectricActivity mainActivity = Robolectric.setupActivity(RobolectricActivity.class);
        CheckBox checkBox = (CheckBox) mainActivity.findViewById(R.id.checkbox);
        assertTrue(!checkBox.isChecked());
        checkBox.performClick();
        assertTrue(checkBox.isChecked());

    }

    /**
     * 测试Dialog
     */
    @Test
    public void testDialog(){
        //点击按钮，出现对话框
        RobolectricActivity mainActivity = Robolectric.setupActivity(RobolectricActivity.class);
        Button dialogBtn = (Button) mainActivity.findViewById(R.id.dialog_btn);
        dialogBtn.performClick();

        AlertDialog latestAlertDialog = ShadowAlertDialog.getLatestAlertDialog();
        assertNotNull(latestAlertDialog);
    }

    /**
     * 测试Toast
     */
    @Test
    public void testToast(){
        //点击按钮，出现吐司
        RobolectricActivity mainActivity = Robolectric.setupActivity(RobolectricActivity.class);
        Button toastBtn = (Button) mainActivity.findViewById(R.id.toast_btn);
        toastBtn.performClick();
        assertEquals(ShadowToast.getTextOfLatestToast(),"I'm HaHa");
    }

    /**
     * 测试Fragment
     */
    @Test
    public void testFragment(){
        RobolectricFragment robolectricFragment = new RobolectricFragment();
        //此api可以主动添加Fragment到Activity中，因此会触发Fragment的onCreateView()
        SupportFragmentTestUtil.startFragment(robolectricFragment);
        assertNotNull(robolectricFragment.getView());
    }

    /**
     * 资源访问
     */
    @Test
    public void testResources() {
        Application application = RuntimeEnvironment.application;
        String appName = application.getString(R.string.app_name);
        assertEquals("ae", appName);
    }


    /**
     * 测试广播
     */
    @Test
    public void testBoradcast(){
        ShadowApplication shadowApplication = ShadowApplication.getInstance();

        String action = "gift.witch.android.action.robolectric";
        Intent intent = new Intent(action);
        intent.putExtra("data", "I'm HaHa");

        //测试是否注册广播接收者
        assertTrue(shadowApplication.hasReceiverForIntent(intent));

        //以下测试广播接受者的处理逻辑是否正确
        RobolectricReceiver myReceiver = new RobolectricReceiver();
        myReceiver.onReceive(RuntimeEnvironment.application,intent);
        Application application = RuntimeEnvironment.application;
        SharedPreferences preferences = application.getSharedPreferences("datas", Context.MODE_PRIVATE);
        assertEquals( "I'm HaHa0",preferences.getString("data", ""));
    }


    /**
     * 测试service
     */
    @Test
    public void addsDataToSharedPreference() {

        Application application = RuntimeEnvironment.application;
        RoboSharedPreferences preferences = (RoboSharedPreferences) application
                .getSharedPreferences("datas", Context.MODE_PRIVATE);

        ServiceController<RobolectricIntentService> serviceController = Robolectric.buildService(RobolectricIntentService.class);
        Intent intent = new Intent(application,RobolectricIntentService.class);
        intent.putExtra("data0","service data");
        serviceController.get().onHandleIntent(intent);

        assertEquals(preferences.getString("data0", ""), "service data0");

    }

}

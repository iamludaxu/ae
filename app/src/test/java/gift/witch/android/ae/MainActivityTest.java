package gift.witch.android.ae;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import gift.witch.android.ae.message.MessageActivity;

import static org.junit.Assert.assertEquals;

@RunWith(MyRobolectricTestRunner.class)
@Config(manifest = "./src/main/AndroidManifest.xml",sdk = 23)
public class MainActivityTest {

    @Test
    public void testMainActivity() {
        MessageActivity mainActivity = Robolectric.setupActivity(MessageActivity.class);
        mainActivity.findViewById(R.id.btn1).performClick();
        assertEquals(4, 2 + 1);
    }

}

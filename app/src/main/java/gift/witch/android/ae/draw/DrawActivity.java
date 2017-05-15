package gift.witch.android.ae.draw;

import android.os.Bundle;
import android.widget.Button;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;

/**
 *
 * https://iamludaxu.gitbooks.io/android/content/draw.html
 *
 */
public class DrawActivity extends BaseCompatActivity {



    private Button mBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        mBut = (Button)findViewById(R.id.btn);
    }

}

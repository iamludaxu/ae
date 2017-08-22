package gift.witch.android.ae.glide;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;
import gift.witch.glide.GlideApp;


/**
 *
 *
 */
public class GlideActivity extends BaseCompatActivity implements View.OnClickListener {


    private final static String TAG = "GlideActivity";

    private String url = "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=6c444b100055b31988f48a362bc0e853/eac4b74543a982260c7b2c368082b9014a90eb6d.jpg";
    private String gif = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503403604564&di=87b5ae39981ebbf70083f2988825aa1a&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2Fupload%2F20151022%2Fudxbav531mmgif.gif";
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide);

        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);
        imageView3 = (ImageView) findViewById(R.id.image3);
        imageView4 = (ImageView) findViewById(R.id.image4);


        GlideApp.with(this).load(url)
                .placeholder(R.drawable.image320)
                .fallback(new ColorDrawable(Color.CYAN))
                .error(new ColorDrawable(Color.BLUE))
                .into(imageView1);


        RequestOptions cropOptions = new RequestOptions().circleCrop();
        cropOptions.transform(new RoundedCorners(20));

        GlideApp.with(this).asBitmap().load(url)
                .placeholder(R.drawable.image320)
                .apply(cropOptions)
                .fallback(new ColorDrawable(Color.CYAN))
                .error(new ColorDrawable(Color.BLUE))
                .into(imageView2);

        GlideApp.with(this).asBitmap().load(url)
                .transform(new RoundedCorners(10))
                .into(imageView3);



        GlideApp.with(this).load(url)
                .placeholder(R.drawable.image320)
                .fallback(new ColorDrawable(Color.CYAN))
                .error(new ColorDrawable(Color.BLUE))
                .apply(cropOptions)
                .into(imageView4);
    }


    @Override
    public void onClick(View v) {

    }
}

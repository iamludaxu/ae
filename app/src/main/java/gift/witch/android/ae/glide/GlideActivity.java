package gift.witch.android.ae.glide;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;

import gift.witch.android.ae.R;
import gift.witch.android.ae.base.BaseCompatActivity;
import gift.witch.glide.GlideApp;


/**
 *
 *
 */
public class GlideActivity extends BaseCompatActivity implements View.OnClickListener {


    private final static String TAG = "GlideActivity";

    private String url = "http://img.ivsky.com/img/tupian/pre/201707/24/meilidexiangcunmeijingtupian-003.jpg";
    private String urlgifUrl = "http://img.qqzhi.com/upload/img_4_1566750187D3165349633_23.jpg";
    private String gif = "http://pic27.nipic.com/20130323/12013739_171719485183_2.gif";
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_glide);

        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);
        imageView3 = (ImageView) findViewById(R.id.image3);
        imageView4 = (ImageView) findViewById(R.id.image4);
        imageView5 = (ImageView) findViewById(R.id.image5);
        imageView6 = (ImageView) findViewById(R.id.image6);
        imageView7 = (ImageView) findViewById(R.id.image7);


        Glide.with(this)//获取上下文环境
                .load(url)//图片地址
                .into(imageView1);//图片显示的地方

        Glide.with(this).load(R.drawable.hsk1).into(imageView1);

        File file = new File("图片地址");
        Glide.with(this).load(file).into(imageView1);


        Uri uri = Uri.parse(url);
        Glide.with(this).load(uri).into(imageView1);

        GlideApp.with(this).load(url)
                .placeholder(R.drawable.image320)//加载的时候占位
                .error(new ColorDrawable(Color.BLUE))//请求资源失败的时候
                .fallback(new ColorDrawable(Color.CYAN))//当请求内容为null的时候显示
                .into(imageView2);

        RequestOptions requestOptions = new RequestOptions();
        //占位符
        requestOptions.placeholder(R.drawable.image320);
        requestOptions.error(new ColorDrawable(Color.BLUE));
        requestOptions.fallback(new ColorDrawable(Color.CYAN));
        //转换
        requestOptions.transform(new RoundedCorners(20));
        //缓存策略
        requestOptions.skipMemoryCache(false);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        //
        requestOptions.encodeFormat(Bitmap.CompressFormat.WEBP);//图片格式
        requestOptions.encodeQuality(90);//图片质量
        requestOptions.format(DecodeFormat.PREFER_RGB_565);//图片模式
        requestOptions.override(40,40);//图片限制大小
        //requestOptions.signature(Key.CHARSET);



        requestOptions.dontTransform();//禁止转换
        requestOptions.dontAnimate();//禁止动画化

        /**
         * 图片转换
         */
        requestOptions.centerInside();
        requestOptions.centerCrop();
        requestOptions.circleCrop();
        requestOptions.fitCenter();


        GlideApp.with(this).load(url)
                .apply(requestOptions)
                .into(imageView3);

        /**
         * 不显示到ImageView里
         */
        SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>(50,50){

            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                imageView4.setImageBitmap(resource);
            }
        };

        GlideApp.with(this).asBitmap().load(url)
                .into(simpleTarget);



        RequestOptions cropOptions = new RequestOptions().centerCrop();
        cropOptions.dontTransform();
        GlideApp.with(this).load(url)
                .placeholder(R.drawable.image320)
                .fallback(new ColorDrawable(Color.CYAN))
                .error(new ColorDrawable(Color.BLUE))
                .apply(cropOptions);
    }



    @Override
    public void onClick(View v) {

    }
}

package gift.witch.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

/**
 * 自定义模糊
 */
public class MyBlurTransformation extends BitmapTransformation {

    private static final String ID = "gift.witch.glide.MyBlurTransformation";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

    private static int MAX_RADIUS = 25;
    private static int DEFAULT_DOWN_SAMPLING = 1;

    private int mRadius;
    private int mSampling;

    private Context mContext;


    public MyBlurTransformation(Context context) {
        init(context, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public MyBlurTransformation(Context context, BitmapPool pool) {
        init(context, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public MyBlurTransformation(Context context, BitmapPool pool, int radius) {
        init(context, radius, DEFAULT_DOWN_SAMPLING);
    }

    public MyBlurTransformation(Context context, int radius) {
        init(context, radius, DEFAULT_DOWN_SAMPLING);
    }

    public MyBlurTransformation(Context context, int radius, int sampling) {
        init(context, radius, sampling);
    }

    private void init(Context context, int radius, int sampling) {
        mContext = context.getApplicationContext();
        mRadius = radius;
        mSampling = sampling;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {

        Bitmap source = getAlphaSafeBitmap(pool, toTransform);

        int width = source.getWidth();
        int height = source.getHeight();
        int scaledWidth = width / mSampling;
        int scaledHeight = height / mSampling;

        Bitmap bitmap = pool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        canvas.scale(1 / (float) mSampling, 1 / (float) mSampling);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(source, 0, 0, paint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            try {
                bitmap = RSBlur.blur(mContext, bitmap, mRadius);
            } catch (RSRuntimeException e) {
                bitmap = FastBlur.blur(bitmap, mRadius, true);
            }
        } else {
            bitmap = FastBlur.blur(bitmap, mRadius, true);
        }

        if (!source.equals(toTransform)) {
            pool.put(source);
        }

        return bitmap;
    }

    private Bitmap getAlphaSafeBitmap(@NonNull BitmapPool pool,
                                             @NonNull Bitmap maybeAlphaSafe) {
        if (Bitmap.Config.ARGB_8888.equals(maybeAlphaSafe.getConfig())) {
            return maybeAlphaSafe;
        }

        Bitmap argbBitmap = pool.get(maybeAlphaSafe.getWidth(), maybeAlphaSafe.getHeight(),
                Bitmap.Config.ARGB_8888);
        new Canvas(argbBitmap).drawBitmap(maybeAlphaSafe, 0 /*left*/, 0 /*top*/, null /*pain*/);

        // We now own this Bitmap. It's our responsibility to replace it in the pool outside this method
        // when we're finished with it.
        return argbBitmap;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        byte[] radiusData = ByteBuffer.allocate(4).putInt(mRadius).array();
        messageDigest.update(radiusData);
    }
}

package gift.witch.glide;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

import java.io.InputStream;


@GlideModule
public final class MyAppGlideModule extends AppGlideModule {

    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {

        registry.replace(GlideUrl.class, InputStream.class,new OkHttpsUrlLoader.Factory());
        registry.append(Photo.class, InputStream.class,new PhotoModelLoader.Factory());
    }


    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // Default empty impl.
        //设置Bitmap的缓存池
        builder.setBitmapPool(new LruBitmapPool(30));

        //设置内存缓存
        builder.setMemoryCache(new LruResourceCache(30));

        //设置磁盘缓存
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context));

        //设置读取不在缓存中资源的线程
        builder.setResizeExecutor(GlideExecutor.newSourceExecutor());

        //设置读取磁盘缓存中资源的线程
        builder.setDiskCacheExecutor(GlideExecutor.newDiskCacheExecutor());

        //设置日志级别
        builder.setLogLevel(Log.VERBOSE);

        //设置全局选项
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.format(DecodeFormat.PREFER_RGB_565);
        builder.setDefaultRequestOptions(requestOptions);

    }

    // Disable manifest parsing to avoid adding similar modules twice.
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
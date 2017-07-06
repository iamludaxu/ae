package gift.witch.android.ae.guava;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;
import org.mockito.internal.util.collections.Sets;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 */
public class GuavaCacheTest {


    @Test
    public void cache() {
        LoadingCache<String, String> stringStringLoadingCache = CacheBuilder.newBuilder().recordStats().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                if(key.equals("key2")){
                    System.out.println("load key2");
                    return "values2";
                }
                System.out.println("load else");
                return "values0";
            }
            public Map<String, String> loadAll(Iterable<? extends String> keys) throws Exception {
                System.out.println("loadAll:"+keys.toString());
                Map<String,String> loadAll = new HashMap<String, String>();
                Iterator keysIt = keys.iterator();
                while (keysIt.hasNext()){
                    String key = (String) keysIt.next();
                    loadAll.put(key,key+":::values");
                }
                return loadAll;
            }


        });
        stringStringLoadingCache.put("key1","value1");
        String values1 = stringStringLoadingCache.getUnchecked("key1");
        System.out.println(values1);
        String values2 = stringStringLoadingCache.getUnchecked("key2");
        System.out.println(values2);
        String values3 = stringStringLoadingCache.getUnchecked("key3");
        System.out.println(values3);
        String values11 = stringStringLoadingCache.getUnchecked("key1");
        System.out.println(values11);
        Set<String> keySet = Sets.newSet("key4");
        try {
            ImmutableMap<String, String> immutableMap = stringStringLoadingCache.getAll(keySet);
            System.out.println(immutableMap.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        CacheStats cacheStats = stringStringLoadingCache.stats();
        System.out.println(cacheStats.toString());
        /*
        value1
        load key2
        values2
        load else
        values0
        value1
        loadAll:[key4]
        {key4=key4:::values}
        CacheStats{hitCount=2, missCount=3, loadSuccessCount=3, loadExceptionCount=0, totalLoadTime=12362388, evictionCount=0}
         */

    }


}

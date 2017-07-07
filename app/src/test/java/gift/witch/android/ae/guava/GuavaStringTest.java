package gift.witch.android.ae.guava;


import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 */
public class GuavaStringTest {


    @Test
    public void joiner() {
        /**
         * 连接器
         */
        Joiner joiner = Joiner.on(":").skipNulls();
        String string = joiner.join("AAA", null, "BBB", "CCC");
        String string0 = joiner.join(Arrays.asList("DDD", "EEEE"));
        System.out.println(string);
        System.out.println(string0);
    }


    @Test
    public void splitter() {
        /**
         * 分拆器
         */
        Iterable<String> stringSet= Splitter.on(',')
                //.limit(3)
                .omitEmptyStrings()
                .trimResults()
                .split("a,b,,c,d,e,f");
        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



}

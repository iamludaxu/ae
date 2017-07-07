package gift.witch.android.ae.guava;


import com.google.common.math.IntMath;
import com.google.common.reflect.TypeToken;

import org.junit.Test;

/**
 */
public class GuavaMathTest {


    @Test
    public void test0() {
        try {
            /**
             * 这里相加不会报错
             */
            int i0 = Integer.MAX_VALUE + 2;
            System.out.println(i0);
            /**
             * 这里会抛出异常，java.lang.ArithmeticException: overflow
             */
            int i1 = IntMath.checkedAdd(Integer.MAX_VALUE, 2);
            TypeToken<String> typeToken = TypeToken.of(String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

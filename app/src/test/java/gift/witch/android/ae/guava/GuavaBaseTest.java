package gift.witch.android.ae.guava;


import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

public class GuavaBaseTest {

    class TestData {
        private int anInt;
        private String string;

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

    @Test
    public void optionalTest() {
        /**
         * 创建指定引用的Optional实例
         */
        //Optional<Integer> integerOptional = Optional.fromNullable(888);
        /**
         * 创建指定引用的Optional实例为null
         */
        //Optional<Integer> integerOptional = Optional.fromNullable(null);
        /**
         * 创建引用缺失的Optional实例
         */
        //Optional<Integer> integerOptional = Optional.absent();
        /**
         * 创建指定引用的Optional实例为null，直接报错NullPointerException
         */
        //Optional<Integer> integerOptional = Optional.of(null);
        /**
         * 创建指定引用的Optional实例
         */
        Optional<Integer> integerOptional = Optional.of(777);
        boolean isPresent = integerOptional.isPresent();
        System.out.println(isPresent);
        Integer integer = integerOptional.orNull();
        System.out.println(integer);
        /**
         * or 如果缺失就返回"666"
         */
        Integer integer1 = integerOptional.or(666);
        System.out.println(integer1);
        /**
         * 就返回引用 否则抛出java.lang.IllegalStateException
         */
        try {
            System.out.println(integerOptional.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 创建一个集合，如果是null那么
         */
        Set<Integer> set = integerOptional.asSet();
        Iterator<Integer> integers = set.iterator();
        while (integers.hasNext()) {
            System.out.println(integers.next());
        }
    }

    @Test
    public void objectTest() {

        TestData testData1 = new TestData();
        testData1.setAnInt(0);
        testData1.setString("string");
        TestData testData2 = new TestData();
        testData2.setAnInt(0);
        testData2.setString("string");
        boolean isEqual = Objects.equal(testData1, testData2);
        System.out.println(isEqual);
        System.out.println("testData1:" + testData1.hashCode() + "    testData2:" + testData2.hashCode());
        int s1Hash = Objects.hashCode(testData1);
        int s2Hash = Objects.hashCode(testData2);
        System.out.println("s1Hash:" + s1Hash + "    s2Hash:" + s2Hash);
    }

    /**
     * 前置条件
     */
    @Test
    public void preconditionsTest() {
        String string = "string";
        /**
         * 检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull。
         */
        String string0 = Preconditions.checkNotNull(string);
        System.out.println(string0);

        /**
         * 检查boolean是否为true，用来检查传递给方法的参数。
         */
        int i = 91;
        int j = 92;
        Preconditions.checkArgument(i < j, "Expected i < j, but %s > %s", i, j);

        /**
         * 用来检查对象的某些状态 抛出的异常 为IllegalStateException
         */
        int n = 90;
        int m = 91;
        Preconditions.checkArgument(n < m, "Expected n < m, but %s > %s", n, m);

        /**
         * 检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size  返回index
         * 索引值常用来查找列表、字符串或数组中的元素，如List.get(int), String.charAt(int)
         */
        int checkElementIndex = Preconditions.checkElementIndex(1, 3, "checkElementIndex() desc");
        System.out.println(checkElementIndex);

        /**
         * 检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size 返回index
         * * 位置的index 可以等于 size* *
         * 位置值和位置范围常用来截取列表、字符串或数组，如List.subList(int，int), String.substring(int)
         */
        int checkPositionIndex = Preconditions.checkPositionIndex(2, 2, "checkPositionIndex() desc");
        System.out.println(checkPositionIndex);

        /**
         * 检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效
         */
        try {

            Preconditions.checkPositionIndexes(0, 0, 0);
            Preconditions.checkPositionIndexes(0, 0, 1);
            Preconditions.checkPositionIndexes(0, 1, 1);
            Preconditions.checkPositionIndexes(1, 1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

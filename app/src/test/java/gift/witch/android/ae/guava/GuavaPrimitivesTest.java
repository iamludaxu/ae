package gift.witch.android.ae.guava;


import com.google.common.primitives.Ints;

import org.junit.Test;

import java.util.List;

/**
 */
public class GuavaPrimitivesTest {


    @Test
    public void primitTest() {
        int[] ints= {1,2,3};
        int[] ints0= {8,9,0};

        List<Integer> integerList = Ints.asList(ints);
        for (Integer integerListItem:integerList){
            System.out.println(integerListItem);
        }
        //123
        System.out.println("================");

        int[] ints1 = Ints.toArray(integerList);
        for (int i :ints1){
            System.out.println(i);
        }
        //123
        System.out.println("================");

        int[] ints2 = Ints.concat(ints,ints0);
        for (int i :ints2){
            System.out.println(i);
        }
        //123890
        System.out.println("================");

        boolean isContains = Ints.contains(ints,2);
        System.out.println(isContains);
        //true
        System.out.println("================");

        int index = Ints.indexOf(ints,0);
        System.out.println(index);
        //-1
        System.out.println("================");

        int index1 = Ints.indexOf(ints,1);
        System.out.println(index1);
        //0
        System.out.println("================");

        int max = Ints.max(ints2);
        System.out.println(max);
        //9
        System.out.println("================");

        int min = Ints.min(ints2);
        System.out.println(min);
        //1
        System.out.println("================");

        String string = Ints.join(";",ints);
        System.out.println(string);
        //1;2;3
        System.out.println("================");

        int c = Ints.constrainToRange(-3,0,9);
        System.out.println(c);
        //0
        System.out.println("================");

    }


}

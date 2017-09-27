package gift.witch.android.ae.structure;


import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

public class ListTest {

    @Test
    public void dd(){
        String[] coins = { "abcdf", "bcd", "dime", "quarter", "dollar" };
        Set set = new TreeSet();
        for (int i = 0; i < coins.length; i++)
            set.add(coins[i]);
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for(int i=0;i<=10;i++)
            System.out.print("-");
        System.out.println("");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }

    public static void main(String[] args) {
    }
}

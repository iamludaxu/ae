package gift.witch.android.ae.guava;


import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Range;

import org.junit.Test;

import java.util.Iterator;

/**
 */
public class GuavaRangeTest {


    @Test
    public void rangeTest() {
        Range range0 = Range.closedOpen(0,4);//[0,4)
        Range range1 = Range.openClosed(3,5);//(3,5]
        System.out.println(range0.toString());
        //[0..4)
        System.out.println(range1.toString());
        //(3..5]

        /**
         * 判断是否是空区间
         */
        boolean isEmpty = range0.isEmpty();
        System.out.println("isEmpty:"+isEmpty);
        //isEmpty:false

        /**
         * 判断是否有上限
         */
        boolean hasLowerBound = range0.hasLowerBound();
        boolean hasUpperBound = range0.hasUpperBound();
        System.out.println("hasLowerBound:"+hasLowerBound +"   hasUpperBound:"+hasUpperBound);
        //hasLowerBound:true   hasUpperBound:true

        /**
         * 返回区间边界类型，CLOSED或OPEN；如果区间没有对应的边界，抛出IllegalStateException；
         */
        BoundType lowerBoundType = range0.lowerBoundType();
        BoundType upperBoundType = range0.upperBoundType();
        System.out.println("hasLowerBound:"+hasLowerBound +"   hasUpperBound:"+hasUpperBound);
        //hasLowerBound:true   hasUpperBound:true

        /**
         * 返回区间的端点值
         */
        Comparable<Integer> lowerEndpoint = range0.lowerEndpoint();
        Comparable<Integer> upperEndpoint = range0.upperEndpoint();
        System.out.println("lowerEndpoint:"+lowerEndpoint +"   upperEndpoint:"+upperEndpoint);
        //lowerEndpoint:0   upperEndpoint:4

        /**
         * 区间之间的包含关系
         */
        boolean encloses = range0.encloses(range1);
        System.out.println("encloses:"+encloses);
        //encloses:false

        /**
         * 判断区间是否是相连
         */
        boolean isConnected = range0.isConnected(range1);
        System.out.println("isConnected:"+isConnected);
        //isConnected:true

        /**
         * 交集：既包含于第一个区间，又包含于另一个区间的最大区间
         */
        Range range2 = range0.intersection(range1);
        System.out.println("intersection:"+range2.toString());
        //intersection:(3..4)


        /**
         * 跨区间：同时包括两个区间的最小区间
         */
        Range rang3 = range0.span(range1);
        System.out.println("span:"+rang3.toString());
        //span:[0..5]

        ImmutableSortedSet set = ContiguousSet.create(range0, DiscreteDomain.integers());
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}

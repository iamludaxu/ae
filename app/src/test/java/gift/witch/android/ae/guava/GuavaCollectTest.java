package gift.witch.android.ae.guava;


import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeRangeSet;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
public class GuavaCollectTest {


    @Test
    public void immutable() {
        Set<String> sets = new HashSet<>();
        sets.add("set obj1");
        sets.add("set obj2");
        ImmutableSet<String> immutableSet = ImmutableSet.copyOf(sets);
        System.out.println(immutableSet.size());


        ImmutableSet immutableSet1 = ImmutableSet.builder().add("ImmutableSet obj1").add("ImmutableSet obj2").build();
        System.out.println(immutableSet1.size());


        ImmutableSet<String> immutableSet2 = ImmutableSet.of("a", "b", "c", "a", "d", "a");
        System.out.println(immutableSet2.size());


    }

    @Test
    public void multiset(){
        /**
         * 相同于set可以重复加入，但是不像set有顺序
         */
        Multiset multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("a");
        System.out.println("multiset size:"+multiset.size());

    }

    @Test
    public void multimap(){
        Multimap<String,String> multimap = HashMultimap.create();
        multimap.put("key1","key1 obj1");
        multimap.put("key1","key1 obj2");
        multimap.put("key1","key1 obj3");

        Iterator<String> stringIterator = multimap.get("key1").iterator();
        System.out.println("key values:");
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
        /*
        key values:
        key1 obj3
        key1 obj2
        key1 obj1
         */

        /**
         * 转换视图
         */
        Map<String,Collection<String>> map = multimap.asMap();
        Iterator<String > stringIterator1 = map.get("key1").iterator();
        System.out.println("map key values:");
        while (stringIterator1.hasNext()){
            System.out.println(stringIterator1.next());
        }
        /*
        map key values:
        key1 obj3
        key1 obj2
        key1 obj1
         */
    }

    @Test
    public void biMap(){
        BiMap<String, Integer> userIds = HashBiMap.create();
        userIds.put("User1",1);
        userIds.put("User2",2);
        userIds.put("User3",3);
        userIds.put("User4",4);
        String userForId = userIds.inverse().get(2);
        System.out.println(userForId);

    }

    @Test
    public void table(){
        HashBasedTable hashBasedTable = HashBasedTable.create();
        hashBasedTable.put("row1","column1","row1+column1:value");
        hashBasedTable.put("row1","column2","row1+column2:value");
        hashBasedTable.put("row2","column1","row2+column1:value");
        hashBasedTable.put("row3","column2","row2+column2:value");
        Map<String,String> hashBasedTableRowMap = hashBasedTable.row("row1");
        Iterator<String> iterator = hashBasedTableRowMap.keySet().iterator();
        while (iterator.hasNext()){
            String column = iterator.next();
            String value = hashBasedTableRowMap.get(column);
            System.out.println("column:"+column + "  value:"+ value);
        }

    }

    @Test
    public void classToInstanceMap(){
        /**
         *特殊的Map：它的键是类型，而值是符合键所指类型的对象。
         */
        ClassToInstanceMap<Number> numberDefaults= MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));

    }

    @Test
    public void rangSet(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1,10]}
        System.out.println(rangeSet.asRanges().toString());
        rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
        System.out.println(rangeSet.asRanges().toString());
        rangeSet.add(Range.closedOpen(15, 20)); //相连区间; {[1,10], [11,20)}
        System.out.println(rangeSet.asRanges().toString());
        rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
        System.out.println(rangeSet.asRanges().toString());
        rangeSet.remove(Range.open(5, 10)); //分割[1, 10]; {[1,5], [10,10], [11,20)}
        System.out.println(rangeSet.asRanges().toString());

        /**
         * RangeSet最基本的操作，判断RangeSet中是否有任何区间包含给定元素。
         */
        boolean isContains = rangeSet.contains(1);
        System.out.println("isContains:"+isContains);

        /**
         * 返回包含给定元素的区间；若没有这样的区间，则返回null。
         */
        Range<Integer> range = rangeSet.rangeContaining(1);
        System.out.println("range:"+range);
    }


    @Test
    public void newList(){
        /**
         * 静态工厂方法
         */
        List<String> stringList = Lists.newArrayList();
        Set<String> stringSets = Sets.newHashSet();

    }


}

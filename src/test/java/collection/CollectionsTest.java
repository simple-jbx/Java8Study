package collection;

import org.apache.catalina.LifecycleState;
import org.junit.Test;

import java.util.*;

/**
 * Collections工具类
 * Collections 与 Collection有什么区别
 * @className: CollectionsTest
 * @author: simple.jbx
 * @date: 2022/8/29
 **/

public class CollectionsTest {

    /**
     * - **reverse(List):**反转List中元素的顺序
     * - **shuffle(List):**对List集合元素进行随机排序
     * - **sort(List):**根据元素的自然顺序对指定List集合元素按升序排序
     * - **sort(List, Comparator):**根据指定的Comparator产生的顺序对List集合元素进行排序
     * - **swap(List, int, int):**将指定list集合中的i处元素和j处元素进行交换
     * Object max(Collection):根据元素自然排序，返回给定集合中的最大元素
     * Object max(Collection, Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection, Comparator)
     * int frequency(Collection, Object):返回指定集合中指定元素的出现次数
     * void copy(List dest, List src):将src中内容复制到dest中
     * boolean replaceAll(List list, Object oldVal, Object newVal):用newVal替换所有的oldVal
     *  @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/8/31 22:43
     */
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(-666);
        list.add(0);
        list.add(233);
        list.add(233);
        list.add(233);
        list.add(233);
        list.add(666);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        int frec = Collections.frequency(list, 233);
        System.out.println(frec);

        List<Integer> newList = Arrays.asList(new Integer[list.size()]);
        System.out.println(newList);
        Collections.copy(newList, list);
        System.out.println(newList);
        System.out.println(list);
        Collections.synchronizedSet();
        Collections.synchronizedNavigableMap();
        Collections.synchronizedNavigableSet();
        Collections.synchronizedSortedMap();
        Collections.synchronizedSortedSet();
    }
}

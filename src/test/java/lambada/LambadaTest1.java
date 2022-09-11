package lambada;

import org.junit.Test;

import java.util.Comparator;

/**
 * @className: LambadaTest
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/9/11
 **/
public class LambadaTest1 {
    @Test
    public void test01() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love ShenZhen");
            }
        };
        r1.run();

        System.out.println("-----------------------------------");

        Runnable r2 = () -> System.out.println("I love China");
        r2.run();
    }

    @Test
    public void test02() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int com1 = comparator1.compare(1122, 5566);
        System.out.println(com1);
        System.out.println("---------------------------------------");

        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
        int com2 = comparator2.compare(7788, 5566);
        System.out.println(com2);
        System.out.println("---------------------------------------");

        //方法引用
        Comparator<Integer> comparator3 = Integer::compare;
        int com3 = comparator3.compare(7788, 3366);
        System.out.println(com3);
        System.out.println("---------------------------------------");

        Comparator<Integer> comparator4 = Comparator.comparingInt(o -> o);
        int com4 = comparator4.compare(7788, 3366);
        System.out.println(com4);
        System.out.println("---------------------------------------");
    }
}

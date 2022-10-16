package generic;

import org.junit.Test;
import tech.snnukf.java8study.generic.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: GenericTest
 * @author: simple.jbx
 * @date: 2022/9/12
 **/
public class GenericTest1 {

    @Test
    public void test01() {
        //如果定义了泛型类，实例化时未指明，则认为此泛型类为Object类型（不建议）。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        Order<String> order1 = new Order("aa", 999, "Order:aa");
        System.out.println(order1);
        order1.setOrderT("Order:abc");
        System.out.println(order1);
    }

    @Test
    public void test02() {
        SubOrder subOrder1 = new SubOrder();
        //子类继承时指明了父类泛型类型，实例化时不需指明泛型
        subOrder1.setOrderT(666);
        System.out.println(subOrder1);
    }

    @Test
    public void test03() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        //泛型不同的引用不能相互赋值
        //list1 = list2; 不允许的操作
    }

    //泛型方法
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();

        for(E e : arr) {
            list.add(e);
        }
        return list;
    }

    @Test
    public void test04() {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        List<Integer> list = copyFromArrayToList(arr);
        System.out.println(list);
    }

    @Test
    public void test05() {
       CustomerDAO dao1 = new CustomerDAO();
       dao1.add(new Customer());
       List<Customer> list = dao1.getForList(10);

       StudentDAO studentDAO = new StudentDAO();
       studentDAO.add(new Student());
       List<Student> list1 = studentDAO.getForList(10);
    }
}

package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 泛型在继承方面的体现
 * 2. 通配符的使用
 * @className: GenericTest2
 * @author: simple.jbx
 * @date: 2022/9/18
 **/
public class GenericTest2 {
    /**
     * 1. 泛型在继承方面的体现
     *  类A是类B的父类，G<A> G<B>不具备父子关系，是并列关系
     *  补充：A<G> B<G> 是父子关系
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/9/18 16:05
     */
    @Test
    public void test01() {
        List<Object> list1 = null;
        List<String> list2 = null;
        //此时list1和list2的类型不具有父子类关系
        //list1 = list2 编译不通过

        List<String> list3 = null;
        ArrayList<String> list4 = null;
        List<String> list5;
        list3 = list4;
    }

    /**
     * 2. 通配符的使用
     *  通配符 ?
     *
     *  类A是类B的父类，G<A> G<B>不具备父子关系，二者共同的父类是G<?>
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/9/18 16:24
     */
    @Test
    public void test02() {
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<>();
        list2.add("AA");

        List<?> list;
        list = list1;
        list = list2;
        print(list1);
        print(list2);
        //不能像其内部添加数据，除了null
        //list.add("AA");
        list.add(null);

        //可以读
        String str = (String) list.get(0);
        System.out.println(str);
    }

    public void print(List<?> list) {
        if(list == null) {
            return;
        }
        Iterator<?> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}

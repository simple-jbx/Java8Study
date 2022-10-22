package lambada;

import org.junit.Test;
import tech.snnukf.java8study.pojo.Person;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * description: 方法引用
 *
 * @className: MethodRefTest
 * @author: simple.jbx
 * @date: 2022/10/22
 **/
public class MethodRefTest {

    /**
     * description: 对象::实例方法
     * Consumer中的void accept(T t)
     * PrintStream中的 void println(T t)
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 15:23
     */
    @Test
    public void test01() {
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("Hello, ShenZhen");

        System.out.println("***************************");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hello, simple");
    }
    
    /**
     * description:
     * Supplier中的T get()
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 15:35
     */
    @Test
    public void test02() {
        Person person = new Person(01, "simple", 25, "bo");
        Supplier<String> supplier1 = () -> person.getName();
        System.out.println(supplier1.get());
        System.out.println("***************************");
        Supplier<String> supplier2 = person::getNickName;
        System.out.println(supplier2.get());
    }

    /**
     * description: 类::静态方法
     * Comparator int compare(T t1, T t2)
     * Integer int compare(T t1, T t2)
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 15:44
     */
    @Test
    public void test03() {
        Comparator<Integer> comparator1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator1.compare(25, 66));

        System.out.println("*******************");

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(99, 33));
    }

    /**
     * description:
     *
     * Function R apply(T t)
     * Math Long round(Double d)
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:04
     */
    @Test
    public void test04() {
        Function<Double, Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(function1.apply(1.2));
        System.out.println("******************");

        Function<Double, Long> function2 = d -> Math.round(d);
        System.out.println(function2.apply(2.6));
        System.out.println("******************");

        Function<Double, Long> function3 = Math::round;
        System.out.println(function3.apply(3.2));

    }

    /**
     * description: 类::实例方法
     * Compartor int compare(T t1, T t2)
     * String int t1.compareTo(t2)
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:34
     */
    @Test
    public void test05() {
        Comparator<String> comparator1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator1.compare("abc", "acb"));
        System.out.println("******************");

        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("abd", "abc"));
    }

    /**
     * description:
     * BiPredicate boolean test(T t1, T t2)
     * String boolean t1.equals(t2)
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:40
     */
    @Test
    public void test06() {
        BiPredicate<String, String> predicate1 = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate1.test("abc", "cba"));
        System.out.println("**************************");

        BiPredicate<String, String> predicate2 = String::equals;
        System.out.println(predicate2.test("abc", "abc"));
    }

    /**
     * description:
     * Function R apply(T t)
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:51
     */
    @Test
    public void test07() {
        Person person = new Person(01, "simple", 25, "bo");
        Function<Person, String> function1 = p -> p.getName();
        System.out.println(function1.apply(person));
        System.out.println("**********************");
        Function<Person, String> function2 = Person::getNickName;
        System.out.println(function2.apply(person));
    }
}

package lambada;

import org.junit.Test;
import tech.snnukf.java8study.pojo.Person;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * description: 构造器引用 数组引用
 *
 * @className: ConstructorRefTest
 * @author: simple.jbx
 * @date: 2022/10/22
 **/
public class ConstructorRefTest {
    /**
     * description: 构造器引用
     * Supplier T get()
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:55
     */
    @Test
    public void test01() {
        Supplier supplier1 = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        System.out.println(supplier1.get());
        System.out.println("***************");
        Supplier<Person> supplier2 = () -> new Person();
        System.out.println(supplier2.get());
        System.out.println("***************");
        Supplier<Person> supplier3 = Person::new;
        System.out.println(supplier3.get());
    }

    /**
     * description: 构造器引用
     * Function R apply(T t)
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:55
     */
    @Test
    public void test02() {
        Function<Integer, Person> function1 = id -> new Person(id);
        Person person = function1.apply(9999);
        System.out.println(person);
        System.out.println("*************");
        Function<Integer, Person> function2 = Person::new;
        Person person1 = function2.apply(8888);
        System.out.println(person1);
    }

    /**
     * description: 构造器引用
     * BiFunction R apply(T t, U u)
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 16:55
     */
    @Test
    public void test03() {
        BiFunction<Integer, String, Person> function1 = (id, name) -> new Person(id, name);
        System.out.println(function1.apply(1001, "simple01"));
        System.out.println("****************");
        BiFunction<Integer, String, Person> function2 = Person::new;
        System.out.println(function2.apply(1002, "simple02"));
    }

    /**
     * description: 数组引用
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/22 17:20
     */
    @Test
    public void test04() {
        Function<Integer, String[]> function1 = length -> new String[length];
        String[] arr1 = function1.apply(10);
        Arrays.stream(arr1).forEach(System.out::println);
        System.out.println("********************");

        Function<Integer, String[]> function2 = String[]::new;
        String[] arr2 = function2.apply(5);
        System.out.println(Arrays.toString(arr2));
    }
}

package lambada;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * description: java内置4大核心函数式接口
 *
 * | 函数式接口                 | 参数类型 | 返回类型  | 用途                                                      |
 * | -------------------------- | -------- | --------- | --------------------------------------------------------- |
 * | `Consumer<T>`  消费性接口  | `T`      | `void`    | 操作`T`对象，无返回值，`void accept(T t)`                 |
 * | `Supplier<T>`  供给型接口  | 无       | `T`       | 返回 `T`对象，`T get()`                                   |
 * | `Function<T,R>` 函数型接口 | `T`      | `R`       | 操作`T`对象，有返回值，`R apply(T t)`                     |
 * | `Predicate<T>` 断定型接口  | `T`      | `boolean` | 确定`T`是否满足约束，并返回boolean值，`boolean test(T t)` |
 *
 * @className: FunctionInterfaceTest
 * @author: simple.jbx
 * @date: 2022/10/19
 **/
public class FunctionInterfaceTest {
    @Test
    public void test01() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("happy一下，共消费：" + aDouble);
            }
        });

        System.out.println("******************");
        happyTime(1000, money -> System.out.println("happy一下，共消费：" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("烧鸡", "烤鸭", "椰汁鸡", "菠萝啤", "烤红薯");
        List<String> ans0 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("鸭");
            }
        });
        System.out.println(ans0);

        List<String> ans1 = filterString(list, str -> str.contains("鸡"));
        System.out.println(ans1);
    }

    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String str : list) {
            if(predicate.test(str)) {
                filterList.add(str);
            }
        }
        return filterList;
    }
}

package stream;

import org.junit.Test;
import tech.snnukf.java8study.pojo.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @className: StreamAPITest4
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/26
 **/
public class StreamAPITest4 {
    // 规约
    @Test
    public void test1() {
        // reduce(T identity, BinaryOperator) 将流中元素反复结合起来，得到一个值。返回Optional<T>
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integerList
                .stream()
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        // reduce(BinaryOperator) 将流中元素反复结合起来，得到一个值。返回Optional<T>
        Optional<Integer> reduce1 = integerList
                .stream()
                .reduce(Integer::sum);
        System.out.println(reduce1);
    }

    // 收集
    @Test
    public void test2() {
        // collect(Collect c) 将流转换为其他形式。接收一个Collector接口实现，用于给Stream中元素做汇总的方法
        List<User> users = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            User user = User
                    .builder()
                    .name("simple" + i)
                    .age((int) (Math.random() * 50  + i))
                    .build();
            users.add(user);
        }

        List<User> userList = users
                .stream()
                .filter(u -> u.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println(userList);

        Set<User> userSet = users
                .stream()
                .filter(u -> u.getAge() > 30)
                .collect(Collectors.toSet());
        System.out.println(userSet);
    }
}

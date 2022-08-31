package stream;

import org.junit.Test;
import pojo.User;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @className: StreamAPITest3
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/26
 **/
public class StreamAPITest3 {
    //匹配与查找
    @Test
    public void test1() {
        List<User> users = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            User user = User
                    .builder()
                    .name("simple" + i)
                    .age((int) (Math.random() * 50  + i))
                    .build();
            users.add(user);
        }

        // allMatch(Predicate p) 检查所有元素是否匹配条件
        boolean allMatch = users
                .stream()
                .allMatch(u -> u.getAge() > 20);
        System.out.println(allMatch);

        // 是否有元素匹配
        boolean anyMatch = users
                .stream()
                .anyMatch(u -> u.getAge() > 20);
        System.out.println(anyMatch);

        //所有都不匹配
        boolean noneMatch = users
                .stream()
                .noneMatch(u -> u.getAge() > 100);
        System.out.println(noneMatch);

        //返回第一个元素
        Optional<User> first = users
                .stream()
                .findFirst();
        System.out.println(first);

        //返回任意一个元素
        Optional<User> any = users
                .stream()
                .findAny();
        System.out.println(any);
    }

    @Test
    public void test2() {
        List<User> users = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            User user = User
                    .builder()
                    .name("simple" + i)
                    .age((int) (Math.random() * 50  + i))
                    .build();
            users.add(user);
        }

        // 返回流中元素的个数
        long count = users
                .stream()
                .filter(u -> u.getAge() > 20)
                .count();
        System.out.println(count);

        // max(Comparator c) 返回流中最大值
        Optional<Integer> max = users
                .stream()
                .map(User::getAge)
                .max(Integer::compareTo);
        System.out.println(max);

        // min(Comparator c) 返回流中最小值
        Optional<User> min = users
                .stream()
                .min(Comparator.comparingInt(u -> u.getAge()));
        System.out.println(min);

        // forEach(Consumer c) 内部迭代
        users
                .stream()
                .forEach(System.out::println);
    }
}

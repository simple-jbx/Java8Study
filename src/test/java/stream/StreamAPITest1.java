package stream;

import org.junit.Test;
import pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @className: StreamAPITest
 * @description: Stream创建
 * @author: simple.jbx
 * @date: 2022/8/15
 **/
public class StreamAPITest1 {
    //通过集合创建Stream
    @Test
    public void test1() {
        //default Stream<E> stream():返回一个顺序流
        List<User> userList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            User user = User
                    .builder()
                    .name("bo_" + i)
                    .age(20 + i)
                    .build();
            userList.add(user);
        }
        Stream<User> userStream = userList.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<User> UserParallelStream = userList.parallelStream();
    }

    //通过数组创建Stream
    @Test
    public void test2() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        //通过Arrays类的static <T> Stream<T> stream(T[] array)创建Stream
        IntStream stream = Arrays.stream(arr);

        User[] userArr = new User[10];
        for (int i = 0; i < 10; i++) {
            User user = User
                    .builder()
                    .name("bo_" + i)
                    .age(20 + i)
                    .build();
            userArr[i] = user;
        }
        Arrays.stream(userArr);
    }

    //通过Stream of
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    //创建无限流
    @Test
    public void test4() {
        //迭代
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

package stream;

import org.junit.Test;
import pojo.User;

import java.util.*;
import java.util.stream.Stream;

/**
 * @className: StreamAPITest2
 * @description: Stream中间操作测试
 * @author: simple.jbx
 * @date: 2022/8/23
 **/
public class StreamAPITest2 {
    //筛选和切片
    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //filter(Predicate p) 接受Lambada 过滤流中不符合条件的元素
        Arrays
            .stream(arr)
            .filter(t -> t % 2 == 0)
            .forEach(System.out::println);
        System.out.println();

        //limit(n) 截断流，使元素不超过给定数量
        Arrays
            .stream(arr)
            .limit(5)
            .forEach(System.out::println);
        System.out.println();


        //skip(n) 跳过元素，返回一个跳过了前n个元素的流。若流中元素不足n个，则返回一个空的流
        Arrays
            .stream(arr)
            .skip(2)
            .forEach(System.out::println);
        System.out.println();

        //distinct() 筛选 通过元素的hashCode()和equals()去除重复元素
        Arrays
            .stream(arr)
            .distinct()
            .forEach(System.out::println);

    }

    //映射
    @Test
    public void test2() {
        //map(Function f) 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings
                .stream()
                .map(str -> str.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        Stream<Stream<Character>> streamStream = strings.stream().map(StreamAPITest2::fromStreinToStream);
        streamStream.forEach(
                s -> {
                    s.forEach(System.out::println);
                }
        );
        System.out.println();

        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = strings.stream().flatMap(StreamAPITest2::fromStreinToStream);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> fromStreinToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        /* list1.add(list2);
        //[1, 2, 3, [4, 5, 6]]
        System.out.println(list1);*/

        list1.addAll(list2);
        System.out.println(list1);
    }

    //排序
    @Test
    public void test4() {
        // sorted() 自然排序
        List<Integer> integers = Arrays.asList(1, 6, 15, 99, -36, -60, 50, 66, 2);
        integers.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com) 定制排序
        List<User> users = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            User user = User
                    .builder()
                    .name("simple" + i)
                    .age((int) (Math.random() * 50  + i))
                    .build();
            users.add(user);
        }

        users
                .stream()
                .sorted((u1, u2) -> u2.getAge() - u1.getAge())
                .forEach(System.out::println);
    }
}

package io;

import org.junit.Test;
import tech.snnukf.java8study.pojo.Person;

import java.io.*;

/**
 * ObjectStreamTest
 * 1.ObjectInputStream ObjectOutputStream
 * @className: ObjectStreamTest
 * @author: simple.jbx
 * @date: 2022/11/14
 **/
public class ObjectInputOutputStreamTest {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输
     * 使用ObjectOutPutStream实现
     */
    @Test
    public void test01() throws IOException {
        //1.创建流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testObject.txt"));
        //2.序列化
        oos.writeObject("I love java");
        oos.flush();
        oos.writeObject(new Person(1, "simple"));
        oos.flush();
        //3.关闭流
        oos.close();
    }

    /**
     * description: 反序列化
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/11/14 23:13
     */
    @Test
    public void test02() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testObject.txt"));
        Object obj = ois.readObject();
        String str = (String) obj;
        System.out.println(str);
        Person p = (Person) ois.readObject();
        System.out.println(p);
    }
}

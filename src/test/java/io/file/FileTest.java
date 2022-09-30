package io.file;

import org.junit.Test;

import java.io.File;
import java.net.URI;

/**
 * File类的使用
 * 1. File类的一个对象，代表一个文件或一个文件目录（文件夹）
 * 2. 在java.io包下
 *
 * @className: FileTest
 * @author: simple.jbx
 * @date: 2022/9/25
 **/
public class FileTest {

    /**
     * 1. 创建File类实例（相对路径 绝对路径创建）
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/9/25 14:19
     */
    @Test
    public void test01() {
        //构造器1
        File file1 = new File("hello.txt");
        File file2 = new File(URI.create("file:/D:/tomcat/webapps"));
        System.out.println(file1.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());

        //构造器2
        File file3 = new File("D:\\Desktop", "study");
        System.out.println(file3.getPath());

        //构造器3
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4.getPath());
    }
}

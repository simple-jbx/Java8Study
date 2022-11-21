package io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 *  随机存取文件流(RandomAccessFile)
 *  可以实现断点续传（下载）功能
 * @className: RandomAccessFileTest
 * @author: simple.jbx
 * @date: 2022/11/21
 **/
public class RandomAccessFileTest {

    @Test
    public void test01() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("568020.jpg", "r");
        RandomAccessFile raf2 = new RandomAccessFile("56802001.jpg", "rw");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            raf2.write(buffer, 0, len);
        }

        raf1.close();
        raf2.close();
    }

    /**
     * 原文件存在则对原有文件进行覆盖
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/11/21 22:58
     */
    @Test
    public void test02() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.write("simple".getBytes(StandardCharsets.UTF_8));
        raf1.close();
    }


    @Test
    public void test03() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        //寻找下标为5的位置
        raf1.seek(5);
        StringBuffer sb = new StringBuffer();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }

        //调回指针，写入 "aaaaaa"
        raf1.seek(5);
        raf1.write("aaaaaa".getBytes(StandardCharsets.UTF_8));

        raf1.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        raf1.close();
    }
}

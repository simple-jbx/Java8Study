package io;

import org.junit.Test;

import java.io.*;

/**
 * 转换流测试
 * 1. InputStreamReader OutputStreamWriter
 * 2. 提供字节流与字符流之间的转换
 * 3.
 *
 * @className: TransferStreamTest
 * @author: simple.jbx
 * @date: 2022/10/8
 **/
public class TransferStreamTest {

    /**
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/8 23:21
     */
    @Test
    public void test01() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        FileOutputStream fos = new FileOutputStream("out1.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        OutputStreamWriter osr = new OutputStreamWriter(fos, "gbk");

        char[] cbuff = new char[1024];
        int len;
        while ((len = isr.read(cbuff)) != -1) {
            String str = new String(cbuff, 0, len);
            System.out.print(str);
            osr.write(str);
        }

        isr.close();
        osr.close();
    }
}

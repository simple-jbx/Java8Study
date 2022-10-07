package io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流的使用
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 作用：提高流的读取、写入速度
 *
 * @className: BufferStreamTest
 * @author: simple.jbx
 * @date: 2022/9/25
 **/
public class BufferedTest {

    //实现非文本文件的复制
    @Test
    public void test01() {
        //文件
        File srcFile = new File("568020.jpg");
        File outFile = new File("5680200.jpg");
        File srcFile1 = new File("568020.jpg");
        File outFile1 = new File("5680201.jpg");
        //流
        //节点流（字节流）
        FileInputStream inputStream;
        FileOutputStream outputStream;
        FileInputStream inputStream1;
        FileOutputStream outputStream1;
        //缓冲流
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            long startTime = System.currentTimeMillis();
            //流
            //节点流（字节流）
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(outFile);
            inputStream1 = new FileInputStream(srcFile1);
            outputStream1 = new FileOutputStream(outFile1);
            //缓冲流
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            //复制：读取、写入
            byte[] buffer1 = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer1)) != -1) {
                bufferedOutputStream.write(buffer1, 0, len);
            }
            long endTime = System.currentTimeMillis();
            // Consume 6 ms 总耗时与原始文件大小和缓冲区大小有关
            System.out.println("buffered Consume " + (endTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            byte[] buffer2 = new byte[1024];
            int len1;
            while ((len1 = inputStream1.read(buffer2)) != -1) {
                outputStream1.write(buffer2, 0, len1);
            }
            endTime = System.currentTimeMillis();
            //12 ms
            System.out.println("Consume " + (endTime - startTime) + " ms");

        } catch (IOException e) {

        } finally {
            //资源关闭 先关闭外层流 再关闭内层流
            if(bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {

                }
            }

            if(bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {

                }
            }
            //关闭外层流的同时 内层流会自动关闭
            // outputStream.close();
            // inputStream.close();
        }




    }
}

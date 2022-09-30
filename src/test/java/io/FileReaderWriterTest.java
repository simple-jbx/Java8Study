package io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * //TODO... Description
 *
 * @className: FileReaderWriterTest
 * @author: simple.jbx
 * @date: 2022/9/25
 **/
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
    }

    //读入文件并输出到控制台
    @Test
    public void test01() {
        File file = new File("test.txt");
        //提供具体的流
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //数据的读入
            int read;
            while ((read = fr.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用read()重载方法
    @Test
    public void test02() {
        File file = new File("test.txt");
        //提供具体的流
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            //数据的读入
            char[] buffer = new char[10];
            while (fr.read(buffer) != -1) {
                System.out.print(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

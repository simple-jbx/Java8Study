package io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * //TODO... Description
 *
 * @className: FileWriterTest
 * @author: simple.jbx
 * @date: 2022/9/25
 **/
public class FileWriterTest {
    //将内存中数据写入硬盘 文件不存在则穿件并写
    //若文件存在可可根据append参数决定是追加还是覆盖
    @Test
    public void test01() {
        //1. 提供File类对象
        File file= new File("out.txt");
        //2. 提供流 不能用字符流来处理图片等字节数据，
        // 同样的也不能用字节流来处理文本等字符数据
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, false);
            //3. 写
            fw.write("hello out\n");
            fw.write("hello out.txt".toCharArray());
            //4. 关闭流
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * //TODO... Description
 *
 * @className: OtherStreamTest
 * @author: simple.jbx
 * @date: 2022/10/16
 **/
public class OtherStreamTest {
    public static void main(String[] args) {
        InputStreamReader isr;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if("e".equals(data) || "exit".equals(data)) {
                    System.out.println("over");
                    break;
                }
                System.out.println(data.toUpperCase(Locale.ROOT));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

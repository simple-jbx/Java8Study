package tech.snnukf.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTimeTest
 *
 * @className: DateTimeTest
 * @author: simple.jbx
 * @date: 2022/11/13
 **/
public class DateTimeTest {

    @Test
    public void test01() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串-->日期
        String str = "2022-06-06 下午11:33:00";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM.dd hh/mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

    }
}

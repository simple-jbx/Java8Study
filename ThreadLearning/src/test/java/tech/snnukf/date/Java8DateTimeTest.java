package tech.snnukf.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * TODO...
 *
 * @className: Java8DateTimeTest
 * @author: simple.jbx
 * @date: 2022/11/13
 **/
public class Java8DateTimeTest {

    /**
     *  LocalDate、LocalTime、LocalDateTime的使用
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/11/13 21:53
     */
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println("*******************************");

        //of()
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 11, 11, 23, 33, 33);
        System.out.println(localDateTime1);
        System.out.println("*******************************");

        //getXxx() 获取相关属性
        System.out.println(localDateTime1.getYear());
        //一年中的第几天
        System.out.println(localDateTime1.getDayOfYear());
        //当月的第几天
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getMonth());
        //星期几
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getHour());
        System.out.println(localDateTime1.getMinute());
        System.out.println(localDateTime1.getSecond());
        System.out.println("*******************************");

        //设置相关属性 返回新对象，体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(23);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(10);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.plusMonths(1);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
    }

    @Test
    public void test02() {
        //1.预定义的标准格式 ISO_LOCAL_DATE_TIME ISO_LOCAL_DATE ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(str1);
        //解析：字符串-->日期
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);
        System.out.println("*************************************");

        //2.本地化相关的格式，如ofLocalizedDateTime(FormatStyle.Long)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        System.out.println("*************************************");

        //3.自定义的格式。如ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);
        TemporalAccessor parse1 = formatter3.parse(str4);
        System.out.println(parse1);
    }
}

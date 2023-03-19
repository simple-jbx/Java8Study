package tech.snnukf.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.context.junit4.SpringRunner;
import tech.snnukf.base.BaseTest;

/**
 * TODO...
 *
 * @className: SingletonThreadPoolTest
 * @author: simple.jbx
 * @date: 2023/3/18
 **/
@Slf4j
public class SingletonThreadPoolTest extends BaseTest{

    @Test
    public void test01() {
        SingletonThreadPool threadPool = SingletonThreadPool.getThreadPoolInstance();

        threadPool.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            log.info("sum of 1-1000 is [{}]", sum);
        });

        threadPool.submit(() -> {
            long sum = 0;
            for (int i = 1001; i <= 10000; i++) {
                sum += i;
            }
            log.info("sum of 1001-10000 is [{}]", sum);
        });

        threadPool.submit(() -> {
            long sum = 0;
            for (int i = 10001; i <= 100000; i++) {
                sum += i;
            }
            log.info("sum of 10001-100000 is [{}]", sum);
        });
    }

    @Test
    public void test02() {
        SingletonThreadPool threadPool = SingletonThreadPool.getThreadPoolInstance();
        SingletonThreadPool threadPool2 = SingletonThreadPool.getThreadPoolInstance();
        Assert.assertTrue(threadPool == threadPool2);
    }

}

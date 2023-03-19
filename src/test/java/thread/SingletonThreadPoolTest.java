package thread;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.snnukf.java8study.thread.SingletonThreadPool;

/**
 * TODO...
 *
 * @className: SingletonThreadPoolTest
 * @author: simple.jbx
 * @date: 2023/3/18
 **/
@Slf4j
@PrepareForTest(SingletonThreadPool.class)
@PowerMockRunnerDelegate(SpringRunner.class)
public class SingletonThreadPoolTest extends BaseTest {

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
    }

}

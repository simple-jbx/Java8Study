package tech.snnukf.java8study.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * TODO...
 *
 * @className: SingletonCountdownTaskThreadPool
 * @author: simple.jbx
 * @date: 2023/3/12
 **/
public class CountdownTask {

    private CountDownLatch countDownLatch;

    private List<Runnable> taskList;

    public CountdownTask(Runnable ...tasks) {
        countDownLatch = new CountDownLatch(tasks.length);
        taskList = new ArrayList<>(tasks.length);
        Arrays.stream(tasks).forEach(task -> taskList.add(task));
    }

    public void runAndawait(Runnable ...tasks) throws InterruptedException {
        try {
            SingletonThreadPool threadPool = SingletonThreadPool.getThreadPoolInstance();
        } catch (Exception e) {

        } finally {
            countDownLatch.countDown();
        }
        countDownLatch.await();
    }

    public void runAndawait(Long timeout, TimeUnit timeUnit, Runnable... tasks) throws InterruptedException {
        try {

        } catch (Exception e) {

        } finally {
            countDownLatch.countDown();
        }
        countDownLatch.await(timeout, timeUnit);
    }
}





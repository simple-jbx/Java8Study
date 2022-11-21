package tech.snnukf.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * MyThreadCallableTest
 *
 * @className: MyThreadCallableTest
 * @author: simple.jbx
 * @date: 2022/11/12
 **/
public class MyThreadCallableTest {

    @Test
    public void test() throws InterruptedException {
        MyThreadCallable myThreadCallable = new MyThreadCallable();

        FutureTask<MyThreadCallable> futureTask = new FutureTask<MyThreadCallable>(myThreadCallable);

        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(5 * 1000);
    }
}

package tech.snnukf.thread;

import org.junit.Test;

/**
 * description: MyThreadTest
 *
 * @className: MyThreadTest
 * @author: simple.jbx
 * @date: 2022/10/28
 **/
public class MyThreadTest {

    @Test
    public void test01() {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("hello thread");
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.print(i + " main\t");
            }
            if(i > 0 && i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /**
     * Junit测试的时候主线程不会等待子线程执行完因此需要sleep(),或者使用CountDownLatch
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/11/9 23:24
     */
    @Test
    public void test02() throws InterruptedException {
        MyThread2 myThread01 = new MyThread2();
        Thread thread01 = new Thread(myThread01);
        Thread thread02 = new Thread(myThread01);
        thread01.setName("thread01");
        thread02.setName("thread02");
        thread01.start();
        thread02.start();

        Thread.sleep(5*1000);
    }

}

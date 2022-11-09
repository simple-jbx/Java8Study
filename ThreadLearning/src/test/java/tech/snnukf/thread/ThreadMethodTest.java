package tech.snnukf.thread;

import org.junit.Test;

/**
 * description: ThreadMethodTest
 *
 * @className: ThreadMethodTest
 * @author: simple.jbx
 * @date: 2022/11/7
 **/
public class ThreadMethodTest {

    @Test
    public void test01() throws InterruptedException {
        Thread thread = Thread.currentThread();
        MyThread myThread01 = new MyThread();
        myThread01.setName("myThread01");
        myThread01.setPriority(Thread.MIN_PRIORITY);
        myThread01.start();
        thread.setName("Main");
        System.out.println(thread.getName());
        //myThread01.join();
        System.out.println(myThread01.getName());

        MyThread myThread02 = new MyThread();
        myThread02.setName("myThread02");
        myThread02.setPriority(Thread.MAX_PRIORITY);
        myThread02.start();
    }

    @Test
    public void test02() {
        //创建实现类对象
        MyThreadRunnable myThreadRunnable01 = new MyThreadRunnable();
        //将对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread01 = new Thread(myThreadRunnable01);
        thread01.setName("myThreadRunnable01");
        thread01.start();

        MyThreadRunnable myThreadRunnable02 = new MyThreadRunnable();
        //将对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread02 = new Thread(myThreadRunnable02);
        thread02.setName("myThreadRunnable02");
        thread02.start();

    }
}

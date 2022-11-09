package tech.snnukf.thread;

import java.util.Random;

/**
 * TODO...
 *
 * @className: MyThread2
 * @author: simple.jbx
 * @date: 2022/11/8
 **/
public class MyThread2 implements Runnable{
    private static int number = 1;
    private static Object obj  = new Object();
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
       while (number <= 100) {
           synchronized (obj) {
               obj.notify();
               if (number <= 100) {
                   try {
                       Thread.sleep(20);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+":"+(number++));
                   try {
                       if(number <= 100) {
                           obj.wait();
                       }
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               } else {
                   break;
               }
           }
       }
    }

    public static void main(String[] args) {
        MyThread2 myThread01 = new MyThread2();
        MyThread2 myThread02 = new MyThread2();

        Thread thread01 = new Thread(myThread01);
        Thread thread02 = new Thread(myThread02);
        thread01.setName("thread01");
        thread02.setName("thread02");
        thread01.start();
        thread02.start();
    }
}

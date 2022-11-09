package tech.snnukf.thread;

/**
 * MyThreadRunnable
 *
 * @className: MyThreadRunnable
 * @author: simple.jbx
 * @date: 2022/11/7
 **/
public class MyThreadRunnable implements Runnable{
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
        System.out.println("hello thread");
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.print(Thread.currentThread().getName() + "_" + i + "\t");
            }
            if(i > 0 && i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

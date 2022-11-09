package tech.snnukf.thread;

/**
 * description: //TODO... Description
 *
 * @className: MyThread
 * @author: simple.jbx
 * @date: 2022/10/28
 **/
public class MyThread extends Thread{
    /**
     * description: 重写Thread的run()
     *
     * @param:
     * @return: void
     * @author: simple.jbx
     * @date: 2022/10/28 23:02
     */
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.print(this.getName() + " " + i + "\t");
            }
            if(i > 0 && i % 10 == 0) {
                System.out.println();
            }
        }
    }
}

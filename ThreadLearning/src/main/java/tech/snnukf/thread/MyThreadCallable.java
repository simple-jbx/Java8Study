package tech.snnukf.thread;

import java.util.concurrent.Callable;

/**
 * TODO...
 *
 * @className: MyThreadCallable
 * @author: simple.jbx
 * @date: 2022/11/12
 **/
public class MyThreadCallable implements Callable {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if((i & 1) == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }

}

package tech.snnukf.java8study.thread;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * 单例线程池
 *
 * @className: SingletonThreadPool
 * @author: simple.jbx
 * @date: 2023/3/12
 **/
@Slf4j
public class SingletonThreadPool extends ScheduledThreadPoolExecutor {

    /**
     * 线程池默认核心线程数
     * 可以写在配置文件中
     */
    private static int DEFAULT_CORE_SIZE = 10;

    private static volatile SingletonThreadPool singletonThreadPool = null;

    private SingletonThreadPool(int corePoolSize) {
        super(corePoolSize);
    }

    public static SingletonThreadPool getThreadPoolInstance() {
        if(Objects.isNull(singletonThreadPool)) {
            synchronized (SingletonThreadPool.class) {
                if (Objects.isNull(singletonThreadPool)) {
                    singletonThreadPool = new SingletonThreadPool(DEFAULT_CORE_SIZE);
                }
            }
        }
        return singletonThreadPool;
    }

    /**
     * @param task
     * @throws RejectedExecutionException {@inheritDoc}
     * @throws NullPointerException       {@inheritDoc}
     */
    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(() ->
                {
                    //这里可以做一些自定义业务动作 比如打日志 方便出问题追踪
                    MDC.put("serialNumber"/*业务流水key*/, ""/*业务流水value*/);
                    task.run();
                }
        );
    }


    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return super.submit(() ->
        {
            //这里可以做一些自定义业务动作 比如打日志 方便出问题追踪
            MDC.put("serialNumber"/*业务流水key*/, ""/*业务流水value*/);
            try {
                task.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, result);
    }
}

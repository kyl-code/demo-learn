package org.example.common;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public final class BlockThreadPool {
    private ThreadPoolExecutor pool;

    public BlockThreadPool(int poolSize){
        this(poolSize, null);
    }

    public BlockThreadPool(int poolSize, String threadName){
        pool = new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                new BlockThreadFactory(threadName),
                //new ThreadPoolExecutor.AbortPolicy()
                new BlockRejectExecutionHandle()
                );
    }

    public void execute(Runnable runnable){
        this.pool.execute(runnable);
    }

    public void destory(){
        if(null != pool){
            this.pool.shutdown();
        }
    }

    private class BlockThreadFactory implements ThreadFactory{
        private AtomicInteger count = new AtomicInteger(0);
        private String threadName;

        BlockThreadFactory(String threadName){
            this.threadName = threadName;
        }
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName;
            if(StringUtils.isNotBlank(this.threadName)){
                threadName = this.threadName + count.addAndGet(1);
            }else{
                threadName = BlockThreadPool.class.getSimpleName() + count.addAndGet(1);
            }
            t.setName(threadName);
            return t;
        }
    }

    private class BlockRejectExecutionHandle implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                // 当阻塞队列满时，put方法会一直等待
                executor.getQueue().put(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockThreadPool pool = new BlockThreadPool(5);
        for(int i = 1; i<100 ;i++){
            final int j = i;
            System.err.println("提交第" + i +"给任务！");
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        System.err.println("第" + j + "个任务提交成功！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

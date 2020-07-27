package org.example.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintOrder {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        new TestThread(ai, "A", 0).start();
        new TestThread(ai, "B", 1).start();
        new TestThread(ai, "C", 2).start();
    }


    private static class TestThread extends Thread{

        private String threadName;
        private int count = 0;
        private int num;
        private AtomicInteger ai;

        TestThread(AtomicInteger atomicInteger, String threadName, int num){
            this.threadName = threadName;
            this.num = num;
            this.ai = atomicInteger;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (ai) {
                    if (ai.get() % 3 == num) {
                        ai.set(ai.get()+1);
                        count++;
                        System.err.println(threadName + ":" + count);
                        ai.notifyAll();
                        if(count >= 3){
                            break;
                        }
                    } else {
                        try {
                            ai.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

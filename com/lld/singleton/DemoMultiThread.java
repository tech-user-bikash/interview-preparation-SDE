package com.lld.singleton;

public class DemoMultiThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadFoo());
        Thread t2 = new Thread(new ThreadBar());
        t1.start();
        t2.start();

    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            JudgeAnalytics singleton;
            try {
                singleton = JudgeAnalytics.getInstance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(singleton);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            JudgeAnalytics singleton = null;
            try {
                singleton = JudgeAnalytics.getInstance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(singleton);
        }
    }
}

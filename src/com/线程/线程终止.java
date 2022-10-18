package com.线程;

public class 线程终止 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println("运行中" + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("线程终止" + e.toString());
            }
        };

        Runnable runnable2 = () -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                System.out.println("运行中" + i);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程停止");
                    return;
                }
            }
        };

        Thread thread = new Thread(runnable2);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}


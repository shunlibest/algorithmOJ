package com.线程;

import java.util.Map;

public class 启动线程 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().isAlive();

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();



    }
}

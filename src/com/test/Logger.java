package com.test;

public class Logger {
    public void error(String s, String data, Exception e) {
        System.out.printf(s, data);
    }

    public void error(String compress_error, Exception e) {
        System.out.printf(compress_error);

    }
}

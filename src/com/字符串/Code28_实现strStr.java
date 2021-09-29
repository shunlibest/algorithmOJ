package com.字符串;

public class Code28_实现strStr {

    public static void main(String[] args) {

        int i = strStr("", "");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {

        int i = haystack.indexOf(needle);

//        indexOf()

        return i;

    }
}

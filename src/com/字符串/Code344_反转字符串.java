package com.字符串;

import java.util.Arrays;

public class Code344_反转字符串 {

    public static void main(String[] args) {

        reverseString("abcd".toCharArray());

    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}

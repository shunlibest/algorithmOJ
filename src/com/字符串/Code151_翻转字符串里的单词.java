package com.字符串;

import java.util.Arrays;

public class Code151_翻转字符串里的单词 {

    public static void main(String[] args) {

        reverseWords("abcd");

    }

    public static String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        reverseString(charArray);


        return "";
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

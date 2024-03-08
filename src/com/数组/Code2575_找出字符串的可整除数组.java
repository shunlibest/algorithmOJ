package com.数组;

import java.util.Arrays;

public class Code2575_找出字符串的可整除数组 {

    public static void main(String[] args) {
        String word = "1010";
        int[] res = new Code2575_找出字符串的可整除数组().divisibilityArray(word, 10);
        System.out.println(Arrays.toString(res));
    }

    public int[] divisibilityArray(String word, int m) {
        char[] words = word.toCharArray();

        int[] result = new int[words.length];
        long lastValue = 0;
        for (int i = 0; i < words.length; i++) {
            long value = (words[i] - '0') + lastValue * 10;
            long mode = value % m;
            if (mode == 0) {
                result[i] = 1;
            }
            lastValue = mode;
        }
        return result;
    }
}

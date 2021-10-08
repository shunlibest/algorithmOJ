package com.回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code131_分割回文串 {

    public static void main(String[] args) {
        int[] input = new int[]{10, 1, 2, 7, 6, 1, 5};

        List<List<String>> i = new Code131_分割回文串().partition("");
        System.out.println(i);
    }

    // 存放所有的结果
    List<List<String>> result = new ArrayList<>();
    char[] inputString;

    public List<List<String>> partition(String s) {
        inputString = s.toCharArray();
        partitionHelper(0);
        return result;
    }

    void partitionHelper(int startIndex) {

        for (int i = startIndex; i < inputString.length; i++) {
            if (isPalindrome(inputString,startIndex,i)){

            }

        }

    }


    //判断是否是回文串
    private boolean isPalindrome(char[] s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }


}

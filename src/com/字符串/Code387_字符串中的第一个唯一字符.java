package com.字符串;

public class Code387_字符串中的第一个唯一字符 {

    public static void main(String[] args) {

        int i = firstUniqChar("leetcode");
        System.out.println(i);
    }

    public static int firstUniqChar(String s) {
        int[] nums = new int[26];

        for (char c : s.toCharArray()) {
            nums[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (nums[c - 'a'] == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }
}

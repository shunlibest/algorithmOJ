package com.字符串;

public class Code383_赎金信 {

    public static void main(String[] args) {

        boolean i = canConstruct("aa", "aa");
        System.out.println(i);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];

        for (char c : ransomNote.toCharArray()) {
            nums[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            nums[c - 'a']--;
        }
        for (int i : nums) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}

package com.数组;

import java.util.Arrays;

public class Code128_最长连续序列 {

    public static void main(String[] args) {
        int[] array = {};
        int i = new Code128_最长连续序列().longestConsecutive(array);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int item : nums) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }
        boolean[] list = new boolean[max - min + 1];

        for (int item : nums) {
            list[item - min] = true;
        }
        int maxCount = 0;
        int count = 0;
        for (boolean v : list) {
            if (v) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}

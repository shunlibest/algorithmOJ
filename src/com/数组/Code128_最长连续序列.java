package com.数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code128_最长连续序列 {

    public static void main(String[] args) {
        int[] array = {0,3,7,2,5,8,4,6,0,1};
        int i = new Code128_最长连续序列().longestConsecutive(array);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLongest = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (set.contains(num + length)) {
                length++;
            }
            maxLongest = Math.max(maxLongest, length);
        }
        return maxLongest;
    }

    public int longestConsecutiveError(int[] nums) {
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

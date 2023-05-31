package com.数组;

import java.util.Arrays;

public class Code26_删除有序数组中的重复项 {


    public static void main(String[] args) {
        int[] k = new int[]{1, 1, 2};

        int i = removeDuplicates(k);
        System.out.println(i);
        System.out.println(Arrays.toString(k));

    }


    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (nums[fast] == nums[slow]) {
                fast++;
                if (fast >= nums.length) {
                    return ++slow;
                }
            }
            slow++;
            nums[slow] = nums[fast];
        }
        return slow;
    }
}

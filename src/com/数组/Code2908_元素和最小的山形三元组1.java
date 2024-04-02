package com.数组;

import java.util.Arrays;

public class Code2908_元素和最小的山形三元组1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2};
        int i = new Code2908_元素和最小的山形三元组1().minimumSum(array);
        System.out.println(i);
    }

    public int minimumSum(int[] nums) {
        int[] leftMinArray = new int[nums.length];
        leftMinArray[0] = nums[0];
        int leftMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMin = Math.min(leftMin, nums[i]);
            leftMinArray[i] = leftMin;
        }


        int[] rightMinArray = new int[nums.length];
        int rightMin = nums[nums.length - 1];
        rightMinArray[nums.length - 1] = rightMin;
        for (int i = nums.length - 2; i >= 0; i--) {

            rightMin = Math.min(rightMin, nums[i]);
            rightMinArray[i] = rightMin;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (leftMinArray[i - 1] < nums[i] && rightMinArray[i + 1] < nums[i]) {
                int value = leftMinArray[i - 1] + nums[i] + rightMinArray[i + 1];
                min = Math.min(min, value);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}

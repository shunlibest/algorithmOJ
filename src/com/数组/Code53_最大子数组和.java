package com.数组;

public class Code53_最大子数组和 {
    public static void main(String[] args) {
        int[] input = {-2, -1};
        int i = new Code53_最大子数组和().maxSubArray(input);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], 0);
            maxValue = Math.max(maxValue, currentSum);
        }
        if (maxValue == 0) {
            maxValue = Integer.MIN_VALUE;
            for (int num : nums) {
                maxValue = Math.max(maxValue,num);
            }
        }

        return maxValue;
    }
}

package com.数组.前缀和;

public class Code303_区域和检索_数组不可变 {

    public static void main(String[] args) {
        int[] array = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(array);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {
        private int[] preSum;

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }

        }

        public int sumRange(int left, int right) {
            if (left <= 0) {
                return preSum[right];
            }
            return preSum[right] - preSum[left - 1];
        }
    }
}

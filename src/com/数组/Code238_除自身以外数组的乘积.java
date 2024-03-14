package com.数组;

import java.util.Arrays;

public class Code238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] inputs = {4, 3, 2, 1, 2};
        int[] ints = new Code238_除自身以外数组的乘积().productExceptSelf(inputs);
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] * nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] * nums[i];
        }
        int[] suffixSum = new int[nums.length];
        suffixSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        res[0] = suffixSum[1];
        res[nums.length - 1] = preSum[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = preSum[i - 1] * suffixSum[i + 1];
        }
        return res;
    }
}

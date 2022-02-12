package com.每日一题;

import java.util.Arrays;

public class Code384_打乱数组 {
    int[] nums;
    int[] originalArray;

    public Code384_打乱数组(int[] nums) {
        this.nums = nums;
        originalArray = new int[nums.length];
        System.arraycopy(nums, 0, originalArray, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        Code384_打乱数组 obj = new Code384_打乱数组(input);

        int[] shuffle = obj.shuffle();
        int[] reset = obj.reset();
        int[] shuffle1 = obj.shuffle();


        System.out.println(Arrays.toString(shuffle));

    }

    public int[] reset() {
        return originalArray;
    }

    public int[] shuffle() {


        return nums;
    }


}

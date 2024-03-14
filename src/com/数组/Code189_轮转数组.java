package com.数组;

import java.util.Arrays;

public class Code189_轮转数组 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        new Code189_轮转数组().rotate(array, 2);

        System.out.println(Arrays.toString(array));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] des = new int[nums.length];
        System.arraycopy(nums, 0, des, k, nums.length - k);
        System.arraycopy(nums, nums.length - k, des, 0, k);
        System.arraycopy(des, 0, nums, 0, nums.length);
    }
}

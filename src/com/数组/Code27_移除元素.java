package com.数组;

import java.util.Arrays;

public class Code27_移除元素 {

    public static void main(String[] args) {
        int[] k = new int[]{3, 2, 2, 3};
        int i = removeElement(k, 3);
        System.out.println(Arrays.toString(k));
        System.out.println(i);
    }

    /**
     * 反思：
     * 1.如果有多个循环变量，可以用while()循环，当型循环（别总是用if）
     * 2.双指针，思路
     * 3.在关键的地方，控制不要数组越界
     */
    public static int removeElement(int[] nums, int val) {
        int S1 = 0, S2 = 0;
        while (S2 < nums.length) {
            while (nums[S2] == val) {
                S2++;
                if (S2 >= nums.length) {
                    return S1;
                }
            }
            nums[S1] = nums[S2];
            S1++;
            S2++;
        }
        return S1;
    }

}

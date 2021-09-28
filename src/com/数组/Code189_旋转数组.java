package com.数组;

import java.util.Arrays;

public class Code189_旋转数组 {


    public static void main(String[] args) {
        int[] k = new int[]{-1, -100, 3, 99};
//        int[] k = new int[]{1, 2, 3, 4, 5, 6, 7};

        rotate_O1(k, 2);


    }


    public static void rotate_On(int[] nums, int k) {
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int res = i - k;
            if (res < 0) {
                res += nums.length;
            }
            newArray[i] = nums[res];
        }

        System.out.println(Arrays.toString(newArray));
    }

    //TODO
    public static void rotate_O1(int[] nums, int k) {
        int op = 0;
        int temp = nums[op];
        int jumpValue = nums[op];
        boolean needJump = false;

        for (int i = 0; i < nums.length; i++) {
            int des = op + k;
            if (des >= nums.length) {
                des -= nums.length;
            }

            int t = nums[des];
            nums[des] = temp;
            temp = t;
            op = des;
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

}

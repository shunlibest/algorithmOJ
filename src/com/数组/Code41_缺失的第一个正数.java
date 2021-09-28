package com.数组;

import java.util.Arrays;

public class Code41_缺失的第一个正数 {


    public static void main(String[] args) {
//        int[] k = new int[]{1, 1};
//        int[] k = new int[]{3, 4, -1, 1};
        int[] k = new int[]{1, 2, 3, 4, 5};

        int i = firstMissingPositive_O1_Space(k);
        System.out.println(i);


    }

    public static int firstMissingPositive_ON_Space(int[] nums) {
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }
            newArray[nums[i] - 1] = nums[i];
        }
        System.out.println(Arrays.toString(newArray));

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == newArray[i]) {
                continue;
            } else {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public static int firstMissingPositive_O1_Space(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= 0 || nums[i] > nums.length) {
                continue;
            }

            //这块注意一下，别绕进去了
            if (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums[i]) {
                continue;
            } else {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

}

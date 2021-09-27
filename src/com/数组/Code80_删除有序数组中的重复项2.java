package com.数组;

import java.util.Arrays;

public class Code80_删除有序数组中的重复项2 {


    public static void main(String[] args) {
        int[] k = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        int i = removeDuplicates(k);
        System.out.println(i);
        System.out.println(Arrays.toString(k));

    }

    /**
     * get一个点，这里的快慢指针，本质上差不多就等于是两个数组而已
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 2;
        while (fast < nums.length) {
            while (nums[fast] == nums[slow]) {
                fast++;
                if (fast >= nums.length) {
                    return ++slow;
                }
            }
//            slow++;
            nums[slow + 2] = nums[fast];
        }
        return slow;
    }
}

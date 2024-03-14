package com.双指针;

import java.util.Arrays;

public class Code283_移动零 {

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        new Code283_移动零().moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slowIndex++] = nums[i];
            }
        }

        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

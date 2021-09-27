package com.数组;

import java.util.Arrays;

public class Code80_删除有序数组中的重复项2 {


    public static void main(String[] args) {
        int[] k = new int[]{1, 1, 1, 2, 2, 3};
        int[] Z = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
//
//        int i = removeDuplicates(k);
//        System.out.println(i);
//        System.out.println(Arrays.toString(k));
//

        removeDuplicates2(k);

    }

    /**
     * get一个点，这里的快慢指针，本质上差不多就等于是两个数组而已
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        if (nums.length <= 2) {
            return nums.length;
        }
        while (fast < nums.length) {
            while (nums[fast] == nums[slow]) {
                fast++;
                if (fast >= nums.length) {
                    return (slow + 2);
                }
            }
            if (slow >= 2 && nums[slow] == nums[slow - 2]) {
                nums[slow] = nums[fast];
                fast++;
            } else {
                nums[slow] = nums[slow];
            }
            slow++;
        }
        return slow;
    }

    /**
     * 这里使用两个数组
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
//        int[] newNums = new int[nums.length];
        int current = 0;

        int duplicatesCount = 0;
        int duplicatesValue = nums[0];
        for (int n : nums) {
            if (n == duplicatesValue) {
                duplicatesCount++;
            } else {
                duplicatesValue = n;
                duplicatesCount = 1;
            }
            if (duplicatesCount <= 2) {
                nums[current] = n;
                current++;
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(current);


        return current;
    }

}

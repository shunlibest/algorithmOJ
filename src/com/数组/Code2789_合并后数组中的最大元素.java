package com.数组;

public class Code2789_合并后数组中的最大元素 {

    public static void main(String[] args) {
        int[] array = {5, 3, 3};
        long l = new Code2789_合并后数组中的最大元素().maxArrayValue(array);
        System.out.println(l);
    }


    public long maxArrayValue(int[] nums) {
        long maxValue = 0;
        long current = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= current) {
                current += nums[i];
            } else {
                maxValue = Math.max(maxValue, current);
                current = nums[i];
            }
        }
        return Math.max(maxValue, current);
    }


}

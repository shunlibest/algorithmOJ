package com.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code453_最小操作次数使数组元素相等 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        int res = new Code453_最小操作次数使数组元素相等().minMoves(input);

        System.out.println(res);

    }

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int sum = 0 ;
        for (int n : nums) {
            sum+=(n-min);
        }

        return sum;
    }
}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-08-08 10:25:48
 * 题目名称: 数组中最长的方波
 * 题目类型:
 * 思考:
 */
public class Code2501_longestSquareStreakInAnArray {
    public static void main(String[] args) {
        Solution solution = new Code2501_longestSquareStreakInAnArray().new Solution();
        int[] array = {4, 3, 6, 16, 8, 2};
        int i = solution.longestSquareStreak(array);
        System.out.println(i);

//        int i = solution.binSearch(array, array.length, 100);
//        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSquareStreak(int[] nums) {
            Arrays.sort(nums);
//            Utils.printTable(nums);

            int[] dp = new int[nums.length];
            int max = 1;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;

                int index = binSearch(nums, i, nums[i]);
                if (index != -1) {
                    dp[i] = Math.max(dp[i], dp[index] + 1);
                    max = Math.max(max, dp[i]);
                }
            }

//            Utils.printTable(dp);
            if (max == 1) {
                return -1;
            }

            return max;

        }

        private int binSearch(int[] num, int endIndex, int aim) {
            int leftIndex = 0;
            int rightIndex = endIndex;

            while (leftIndex <= rightIndex) {
                int center = (leftIndex + rightIndex) / 2;
//                System.out.println(center);
                int value = num[center] * num[center];
                if (value > aim) {
                    rightIndex = center - 1;
                } else if (value < aim) {
                    leftIndex = center + 1;
                } else {
                    return center;
                }

            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

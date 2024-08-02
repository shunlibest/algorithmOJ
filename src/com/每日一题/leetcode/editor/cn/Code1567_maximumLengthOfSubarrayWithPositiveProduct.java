package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-01 14:16:57
 * 题目名称: 乘积为正数的最长子数组长度
 * 题目类型:
 * 思考:
 */
public class Code1567_maximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        Solution solution = new Code1567_maximumLengthOfSubarrayWithPositiveProduct().new Solution();

        int[] array = {0, 1, -2, -3, -4};
        int maxLen = solution.getMaxLen(array);

        System.out.println(maxLen);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxLen(int[] nums) {

            int[][] dp = new int[nums.length][2];

            // case 0: 正数最大值
            // case 1: 负数最小值
            int maxLength = 0;
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    if (nums[i] > 0) {
                        dp[i][0] = 1;
                        dp[i][1] = 0;
                    } else if (nums[i] < 0) {
                        dp[i][0] = 0;
                        dp[i][1] = 1;
                    } else {
                        dp[i][0] = 0;
                        dp[i][1] = 0;
                    }
                    maxLength = dp[i][0];
                    continue;
                }

                if (nums[i] > 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                    if (dp[i - 1][1] == 0) {
                        dp[i][1] = 0;
                    } else {
                        dp[i][1] = dp[i - 1][1] + 1;
                    }
                } else if (nums[i] < 0) {
                    // case 0: 正数最大值
                    // case 1: 负数最小值
                    if (dp[i - 1][1] == 0) {
                        dp[i][0] = 0;
                    } else {
                        dp[i][0] = dp[i - 1][1] + 1;
                    }

                    dp[i][1] = dp[i - 1][0] + 1;
                } else {
                    dp[i][0] = 0;
                    dp[i][1] = 0;
                }

                maxLength = Math.max(maxLength, dp[i][0]);
            }

//            Utils.printTable(dp);

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

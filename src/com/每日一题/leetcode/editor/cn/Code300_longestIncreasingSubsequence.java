package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-19 14:38:26
 * 题目名称: 最长递增子序列
 * 题目类型:
 * 思考:
 */
public class Code300_longestIncreasingSubsequence {
    public static void main(String[] args) {

        Solution solution = new Code300_longestIncreasingSubsequence().new Solution();

        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int i = solution.lengthOfLIS(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {

            int[] dp = new int[nums.length];
            int maxValue = 1;
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[i] = 1;
                    continue;
                }

                for (int k = i - 1; k >= 0; k--) {
                    if (nums[i] > nums[k]) {
                        dp[i] = Math.max(dp[i], dp[k] + 1);
                    }
                }
                dp[i] = Math.max(dp[i], 1);

                maxValue = Math.max(dp[i], maxValue);
            }

//            Utils.printTable(dp);

            return maxValue;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

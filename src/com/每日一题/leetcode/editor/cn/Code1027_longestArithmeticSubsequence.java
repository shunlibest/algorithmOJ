package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-08-08 16:55:56
 * 题目名称: 最长等差数列
 * 题目类型:
 * 思考:
 */


public class Code1027_longestArithmeticSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code1027_longestArithmeticSubsequence().new Solution();
//        int[] i0 = {3, 6, 9, 12};
        int[] i0 = {20, 1, 15, 3, 10, 5, 8};
        int i = solution.longestArithSeqLength(i0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            int edge = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt();
            int[][] dp = new int[nums.length][edge * 2 + 1];

            int max = 1;
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], 1);
                for (int j = 0; j < i; j++) {
//                    System.out.println(nums[i] - nums[j] + edge);
                    dp[i][nums[i] - nums[j] + edge] = Math.max(dp[i][nums[i] - nums[j] + edge], dp[j][nums[i] - nums[j] + edge] + 1);

                    max = Math.max(max, dp[i][nums[i] - nums[j] + edge]);
                }
            }

//            Utils.printTable(dp);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

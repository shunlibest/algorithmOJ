package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-01 11:30:37
 * 题目名称: 摆动序列
 * 题目类型:
 * 思考:
 */
public class Code376_wiggleSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code376_wiggleSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int[][] dp = new int[nums.length][];


            for (int i = 0; i < dp.length; i++) {
                // case 0: 不选
//                dp[i][0] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);
                // case 0: 向上
                if (nums[i] > nums[i - 1]) {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][0] + 1;
                } else if (nums[i] < nums[i - 1]) {
                    dp[i][0] = dp[i - 1][1] + 1;
                    dp[i][1] = dp[i - 1][1];
                } else { //相等
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1];
                }

                // case 1: 向下

            }

            return 0;

        }

        private int max(int x, int y, int z) {
            return Math.max(x, Math.max(y, z));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-03 16:20:27
 * 题目名称: 求出所有子序列的能量和
 * 题目类型:
 * 思考:
 */
public class Code3082_findTheSumOfThePowerOfAllSubsequences {
    public static void main(String[] args) {
        Solution solution = new Code3082_findTheSumOfThePowerOfAllSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfPower(int[] nums, int k) {

            int[] selectNums = new int[nums.length + 1];
            System.arraycopy(nums, 0, selectNums, 1, nums.length);
            int[][] dp = new int[selectNums.length][k + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 1;
                        continue;
                    }

                    dp[i][j] = getValue(dp, i - 1, j) + getValue(dp, i - 1, j - selectNums[i]) ;
                }
            }

            return 0;
        }


        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0) {
                return 0;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-02 15:56:28
 * 题目名称: 目标和
 * 题目类型:
 * 思考:
 */
public class Code494_targetSum {
    public static void main(String[] args) {
        Solution solution = new Code494_targetSum().new Solution();

        int[] array = {1,};
        int targetSumWays = solution.findTargetSumWays(array, 3);
        System.out.println(targetSumWays);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int[] selectNums = new int[nums.length + 1];
            System.arraycopy(nums, 0, selectNums, 1, nums.length);

            int max = 0;
            for (int n : nums) {
                max += n;
            }


            int[][] dp = new int[selectNums.length][max * 2 + 1];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {

                    if (i == 0 && j - max == 0) {
                        dp[0][j] = 1;
                        continue;
                    }
                    dp[i][j] = getValue(dp, i - 1, j - selectNums[i]) + getValue(dp, i - 1, j + selectNums[i]);
                }
            }

//            Utils.printTable(dp);


            return getValue(dp, dp.length - 1, max + target);
        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return 0;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

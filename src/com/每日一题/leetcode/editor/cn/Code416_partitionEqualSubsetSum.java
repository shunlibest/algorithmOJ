package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-02 15:33:26
 * 题目名称: 分割等和子集
 * 题目类型:
 * 思考:
 */
public class Code416_partitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new Code416_partitionEqualSubsetSum().new Solution();
        int[] array = {1, 2, 3, 5};
        boolean b = solution.canPartition(array);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {

            int sum = 0;
            for (int n : nums) {
                sum += n;
            }

            if (sum % 2 == 1) {
                return false;
            }
            int[] selectNums = new int[nums.length + 1];
            System.arraycopy(nums, 0, selectNums, 1, nums.length);

            int aim = sum / 2;
            boolean[][] dp = new boolean[selectNums.length][aim + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = true;
                        continue;
                    }

                    dp[i][j] = getValue(dp, i - 1, j) || getValue(dp, i - 1, j - selectNums[i]);
                }
            }

//            Utils.printTable(dp);

            return dp[dp.length - 1][dp[0].length - 1];

        }

        private boolean getValue(boolean[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return false;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

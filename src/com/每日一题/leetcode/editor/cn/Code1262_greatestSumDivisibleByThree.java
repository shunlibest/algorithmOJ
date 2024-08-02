package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-02 10:56:31
 * 题目名称: 可被三整除的最大和
 * 题目类型:
 * 思考:
 */
public class Code1262_greatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new Code1262_greatestSumDivisibleByThree().new Solution();
        int[] array = {3, 6, 5, 1, 8};
        int i = solution.maxSumDivThree(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumDivThree(int[] nums) {
            int[][] dp = new int[nums.length][3];

            for (int i = 0; i < dp.length; i++) {
                int mod = nums[i] % 3;
                if (i == 0) {
                    dp[0][mod] = nums[i];
                    continue;
                }
                // 0: 余数为0
                dp[i][0] = dp[i - 1][(3 - mod) % 3] + nums[i];
                // 1: 余数为1
                dp[i][1] = dp[i - 1][(3 - mod + 1) % 3] + nums[i];
                // 2: 余数为2
                dp[i][2] = dp[i - 1][(3 - mod + 2) % 3] + nums[i];

                for (int j = 0; j < 3; j++) {
                    if (dp[i][j] % 3 != j) {
                        dp[i][j] = 0;
                    }
                }

                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
//            Utils.printTable(dp);
            return dp[dp.length - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

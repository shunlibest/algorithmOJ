package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-02 17:28:29
 * 题目名称: 执行操作可获得的最大总奖励 I
 * 题目类型:
 * 思考:
 */
public class Code3180_maximumTotalRewardUsingOperationsI {
    public static void main(String[] args) {
        Solution solution = new Code3180_maximumTotalRewardUsingOperationsI().new Solution();
        int[] array = {1, 6, 4, 3, 2};
        int i = solution.maxTotalReward(array);
        System.out.println(i);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            int[] selectNums = new int[rewardValues.length + 1];
            System.arraycopy(rewardValues, 0, selectNums, 1, rewardValues.length);

            int sum = 0;
            for (int n : rewardValues) {
                sum += n;
            }
            boolean[][] dp = new boolean[selectNums.length][sum + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {

                    if (i == 0 && j == 0) {
                        dp[0][0] = true;
                        continue;
                    }

                    if (j - selectNums[i] < selectNums[i]) {
                        dp[i][j] = getValue(dp, i - 1, j) || getValue(dp, i - 1, j - selectNums[i]);
                    } else {
                        dp[i][j] = getValue(dp, i - 1, j);
                    }
                }
            }

//            Utils.printTable(dp);

            for (int i = dp[0].length - 1; i >= 0; i--) {
                if (dp[dp.length - 1][i]) {
                    return i;
                }
            }

            return 0;
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

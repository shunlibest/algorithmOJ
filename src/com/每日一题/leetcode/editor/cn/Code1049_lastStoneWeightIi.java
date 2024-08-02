package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-03 11:27:13
 * 题目名称: 最后一块石头的重量 II
 * 题目类型:
 * 思考:
 */
public class Code1049_lastStoneWeightIi {
    public static void main(String[] args) {
        Solution solution = new Code1049_lastStoneWeightIi().new Solution();
        int[] array = {2, 7, 4, 1, 8, 1};
        int i = solution.lastStoneWeightII(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastStoneWeightII(int[] stones) {

            int sum = 0;

            for (int n : stones) {
                sum += n;
            }
            int[] selectList = new int[stones.length + 1];
            System.arraycopy(stones, 0, selectList, 1, stones.length);

            int[][] dp = new int[selectList.length][sum / 2 + 1];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {


                    int select = 0;
                    if (i - 1 >= 0 && j - selectList[i] >= 0) {
                        select = getValue(dp, i - 1, j - selectList[i]) + selectList[i];
                    }
                    dp[i][j] = Math.max(getValue(dp, i - 1, j), select);
                }
            }


//            Utils.printTable(dp);

            int positive = dp[dp.length - 1][dp[0].length - 1];
            int negative = sum - positive;

            return Math.abs(positive - negative);

        }

        int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0) {
                return 0;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

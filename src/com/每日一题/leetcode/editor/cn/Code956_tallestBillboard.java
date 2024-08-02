package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-03 16:40:08
 * 题目名称: 最高的广告牌
 * 题目类型:
 * 思考:
 */
public class Code956_tallestBillboard {
    public static void main(String[] args) {
        Solution solution = new Code956_tallestBillboard().new Solution();

        int[] array = {1, 2, 3, 4, 5, 6};
        int i = solution.tallestBillboard(array);

        System.out.println(i);

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tallestBillboard(int[] rods) {

            int[] selectRoads = new int[rods.length + 1];
            System.arraycopy(rods, 0, selectRoads, 1, rods.length);
            int sum = 0;
            for (int rod : rods) {
                sum += rod;
            }

            if (sum % 2 != 0) {
                return 0;
            }

            boolean[][] dp = new boolean[selectRoads.length][sum / 2 + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = true;
                        continue;
                    }
                    dp[i][j] = getValue(dp, i - 1, j) || getValue(dp, i - 1, j - selectRoads[i]);
                }
            }

            if (dp[dp.length - 1][dp[0].length - 1]) {
                return sum / 2;
            }

//            Utils.printTable(dp);


            return 0;
        }

        private boolean getValue(boolean[][] dp, int x, int y) {
            if (x < 0 || y < 0) {
                return false;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

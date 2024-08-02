package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-03 14:02:12
 * 题目名称: 最接近目标价格的甜点成本
 * 题目类型:
 * 思考:
 */
public class Code1774_closestDessertCost {
    public static void main(String[] args) {
        Solution solution = new Code1774_closestDessertCost().new Solution();

        int[] baseCosts = {3738, 5646, 197, 7652};
        int[] toppingCosts = {5056};
        int i = solution.closestCost(baseCosts, toppingCosts, 9853);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

            int[] selectList = new int[toppingCosts.length + 1];

            System.arraycopy(toppingCosts, 0, selectList, 1, toppingCosts.length);

            boolean[][] dp = new boolean[selectList.length][target * 2 + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = true;
                        continue;
                    }
                    for (int k = 0; k < 3; k++) {
                        dp[i][j] |= getValue(dp, i - 1, j - selectList[i] * k);
                    }

                }
            }

//            Utils.printTable(dp);

            int min = Integer.MAX_VALUE;
            int resultTarget = 0;
//            for (int i = 0; i < dp[0].length; i++) {
//                if (dp[dp.length - 1][i]) {
//                    System.out.println("->" + i);
//                }
//            }

//            System.out.println("->" + dp[dp.length - 1][5056 * 2]);

            for (int i = 0; i < dp[0].length; i++) {

                for (int base : baseCosts) {
                    if (dp[dp.length - 1][i]) {
                        int aim = target - i - base;

                        if (aim == 0) {
                            return i + base;
                        }

//                        System.out.println(i + base);
                        if (Math.abs(aim) < Math.abs(min) || ((Math.abs(aim) == Math.abs(min)) && aim >= min)) {
                            min = aim;
                            resultTarget = i + base;
                        }
                    }
                }

            }
            return resultTarget;
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

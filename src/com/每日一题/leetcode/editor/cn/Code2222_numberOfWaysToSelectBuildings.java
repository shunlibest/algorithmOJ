package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-01 11:22:02
 * 题目名称: 选择建筑的方案数
 * 题目类型:
 * 思考:
 */
public class Code2222_numberOfWaysToSelectBuildings {
    public static void main(String[] args) {
        Solution solution = new Code2222_numberOfWaysToSelectBuildings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numberOfWays(String s) {

            int[][] dp = new int[s.length()][3];


            for (int i = 0; i < dp.length; i++) {

                dp[i][0] = 0;

                for (int j = 0; j < dp[0].length; j++) {

                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

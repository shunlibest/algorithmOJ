package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-06-28 16:30:58
 * 题目名称: 珠宝的最高价值
 * 题目类型:
 * 思考:
 */
public class CodeLCR166_liWuDeZuiDaJieZhiLcof {
    public static void main(String[] args) {
        Solution solution = new CodeLCR166_liWuDeZuiDaJieZhiLcof().new Solution();

        int[][] array = Utils.convertStringTo2DArray("[[0]]");
        int i = solution.jewelleryValue(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jewelleryValue(int[][] frame) {
            int[][] dp = new int[frame.length][frame[0].length];

            for (int i = 0; i < frame.length; i++) {
                for (int j = 0; j < frame[0].length; j++) {
                    dp[i][j] = Math.max(getValue(dp, i - 1, j), getValue(dp, i, j - 1)) + frame[i][j];
                }
            }
            return dp[dp.length - 1][dp[0].length - 1];
        }

        private int getValue(int[][] dp, int i, int j) {
            if (i >= 0 && j >= 0) {
                return dp[i][j];
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-09-03 16:40:37
 * 题目名称: 丑数 II
 * 题目类型:
 * 思考:
 */


public class Code264_uglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new Code264_uglyNumberIi().new Solution();
        Object i0 = 10;
        int i = solution.nthUglyNumber(10);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {

            int[] dp = new int[n];

            int index2 = 0;
            int index3 = 0;
            int index5 = 0;

            dp[0] = 1;
//            dp[0] = 1;
//            dp[0] = 1;

            for (int i = 1; i < dp.length; i++) {
                int value2 = dp[index2] * 2;
                int value3 = dp[index3] * 3;
                int value5 = dp[index5] * 5;

                int min = Math.min(value2, Math.min(value3, value5));
                if (min == value2) {
                    index2++;
                } else if (min == value3) {
                    index3++;
                } else {
                    index5++;
                }
                if (min == dp[i - 1]) {
                    i--;
                    continue;
                }
                dp[i] = min;
            }

//            Utils.printTable(dp);

            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

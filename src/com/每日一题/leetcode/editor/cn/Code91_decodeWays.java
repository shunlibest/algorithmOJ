package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-05 11:13:23
 * 题目名称: 解码方法
 * 题目类型:
 * 思考:
 */
public class Code91_decodeWays {
    public static void main(String[] args) {
        Solution solution = new Code91_decodeWays().new Solution();

        int i = solution.numDecodings("230");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            if (s.startsWith("0")) {
                return 0;
            }
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == 0 ? 0 : 1;
            for (int i = 2; i < dp.length; i++) {
                // 1位
                int value = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');

                if (value == 0) {
                    return 0;
                } else if (value == 10 || value == 20) {
                    dp[i] = dp[i - 2];
                } else if (value > 10 && value < 27) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else if (s.charAt(i - 1) == '0' && value >= 30) {
                    return 0;
                } else {
                    // 2位
                    dp[i] = dp[i - 1];
                }
            }

//            Utils.printTable(dp);
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

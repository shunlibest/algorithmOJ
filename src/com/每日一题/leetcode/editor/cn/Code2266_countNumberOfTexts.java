package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-06-26 17:56:41
 * 题目名称: 统计打字方案数
 * 题目类型:
 * 思考:
 */
public class Code2266_countNumberOfTexts {
    public static void main(String[] args) {
        Solution solution = new Code2266_countNumberOfTexts().new Solution();
        int i = solution.countTexts("222222222222222222222222222222222222");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = 1_000_000_007;

        public int countTexts(String pressedKeys) {
            int[] dp = new int[pressedKeys.length() + 1];
            char[] keyChars = (" " + pressedKeys).toCharArray();
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j <= getCharNum(keyChars[i] - '0'); j++) {
                    if (i >= j && keyChars[i - j + 1] == keyChars[i]) {
                        dp[i] += dp[i - j];
                        dp[i] %= MOD;
                    } else {
                        break;
                    }
                }
            }
            return dp[dp.length - 1];
        }

        private int getCharNum(int n) {
            if (n == 7 || n == 9) {
                return 4;
            }
            return 3;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

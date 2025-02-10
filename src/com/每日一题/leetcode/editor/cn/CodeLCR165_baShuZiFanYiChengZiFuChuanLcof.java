package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-06 10:24:23
 * 题目名称: 解密数字
 * 题目类型:
 * 思考:
 */
public class CodeLCR165_baShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new CodeLCR165_baShuZiFanYiChengZiFuChuanLcof().new Solution();

        int i = solution.crackNumber(216612);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int crackNumber(int ciphertext) {
            String text = String.valueOf(ciphertext);
            int[] dp = new int[text.length() + 1];


            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i < dp.length; i++) {
                int value = (text.charAt(i - 2) - '0') * 10 + (text.charAt(i - 1) - '0');

                if (value >= 10 && value < 26) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }

            }

//            Utils.printTable(dp);
            return dp[dp.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

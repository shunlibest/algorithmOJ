package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-09-20 10:28:02
 * 题目名称: 统计特殊整数
 * 题目类型:
 * 思考:
 */


public class Code2376_countSpecialIntegers {
    public static void main(String[] args) {
        Solution solution = new Code2376_countSpecialIntegers().new Solution();
        Object i0 = 20;
        Object i1 = 135;
        int i = solution.countSpecialNumbers(135);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSpecialNumbers(int n) {

            boolean[] dp = new boolean[n + 1];

            dp[0] = true;

            int count = 0;
            for (int i = 1; i < dp.length; i++) {

                int beforeValue = i / 10;
                int newValue = i % 10;

                if (dp[beforeValue] && !hasSameValue(beforeValue, newValue)) {
                    dp[i] = true;
                    count++;
                }
            }


//            Utils.printTable(dp);
            return count;
        }

        private boolean hasSameValue(int beforeValue, int newValue) {
            char[] beforeChars = String.valueOf(beforeValue).toCharArray();
            char newChar = String.valueOf(newValue).charAt(0);
            for (char beforeChar : beforeChars) {
                if (beforeChar == newChar) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

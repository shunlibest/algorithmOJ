package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-07 18:04:35
 * 题目名称: 执行操作使两个字符串相等
 * 题目类型:
 * 思考:
 */
public class Code2896_applyOperationsToMakeTwoStringsEqual {
    public static void main(String[] args) {
        Solution solution = new Code2896_applyOperationsToMakeTwoStringsEqual().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(String s1, String s2, int x) {
            int[][] dp = new int[s1.length()][2];


            boolean[] s = new boolean[s1.length()];
            for (int i = 0; i < s.length; i++) {
                s[i] = s1.charAt(i) == s2.charAt(i);
            }
//
//            for (int i = 0; i < dp.length; i++) {
//                // case 0: 当前位置属于相同状态
//                if (s[i]) {
//                    dp[i][0] = dp[i - 1][0];
//                } else {
//                    dp[i][0] = dp[i - 1][1]
//
//                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] + 1);
//                }
//
//                // case1: 当前位置属于不相同状态
//                if (!s[i]) {
//                    dp[i][1] = dp[i - 1][1];
//                } else {
//                    dp[i][1] = Math.min(dp[i][0], dp[i - 1][1] + 1); dp[i - 1][1];
//
//                }
//            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

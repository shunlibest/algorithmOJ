package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-12 13:38:49
 * 题目名称: 最长理想子序列
 * 题目类型:
 * 思考:
 */


public class Code2370_longestIdealSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code2370_longestIdealSubsequence().new Solution();
        Object i0 = "acfgbd";
        Object i1 = "abcd";
        int acfgbd = solution.longestIdealString("lkpkxcigcs", 6);
        System.out.println(acfgbd);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestIdealString(String s, int k) {

            int[] dp = new int[s.length()];

            int[] beforeValue = new int[26];
            int max = 1;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;

                for (int j = 0; j < 26; j++) {

                    if (Math.abs(s.charAt(i) - 'a' - j) <= k) {
                        dp[i] = Math.max(dp[i], beforeValue[j] + 1);

                        max = Math.max(max, dp[i]);
                    }
                }


                int index = s.charAt(i) - 'a';
                beforeValue[index] = Math.max(beforeValue[index], dp[i]);
            }

//            Utils.printTable(dp);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

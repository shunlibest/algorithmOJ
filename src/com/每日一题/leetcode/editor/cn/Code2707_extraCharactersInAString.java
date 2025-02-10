package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-08-02 16:47:02
 * 题目名称: 字符串中的额外字符
 * 题目类型:
 * 思考:
 */
public class Code2707_extraCharactersInAString {
    public static void main(String[] args) {
        Solution solution = new Code2707_extraCharactersInAString().new Solution();
        String s = "sayhelloworld";
        String[] wordDict = {"hello", "world"};
        int i = solution.minExtraChar(s, wordDict);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            int[] dp = new int[s.length() + 1];


            for (int i = 1; i < dp.length; i++) {

                dp[i] = dp[i - 1] + 1;
                for (String str : dictionary) {
                    int length = str.length();

                    if (i - length >= 0 && s.substring(i - length, i).equals(str)) {
                        dp[i] = Math.min(dp[i], dp[i - length]);
                    }
                }
            }

            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

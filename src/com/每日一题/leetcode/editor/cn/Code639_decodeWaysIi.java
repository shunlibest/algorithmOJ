package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-05 11:49:36
 * 题目名称: 解码方法 II
 * 题目类型:
 * 思考:
 */
public class Code639_decodeWaysIi {
    public static void main(String[] args) {
        Solution solution = new Code639_decodeWaysIi().new Solution();

        int i = solution.numDecodings("**");

        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[s.length() + 1];

            dp[0] = 1;
//            dp[1] =

            if (s.startsWith("0")) {
                return 0;
            } else if (s.startsWith("*")) {
                dp[1] = 9;
            } else {
                dp[1] = 1;
            }

            for (int i = 2; i < dp.length; i++) {

//                dp[i] = dp[i - 1];
                char currentChar = s.charAt(i - 1);
                char beforeChar = s.charAt(i - 2);

                if (currentChar == '*') {
//                    dp[i] = dp[i - 1] + 9;
                    if (beforeChar == '1') {
                        dp[i] = dp[i - 1] + dp[i - 2] + 18 - 1 - 1;
                    } else if (beforeChar == '2') {
                        dp[i] = dp[i - 1] + dp[i - 2] + 9 + 6 - 1 - 1;
                    } else if (beforeChar == '*') {
                        dp[i] = dp[i - 2] + 17 + dp[i - 1] + 9 - 1 - 1;
                    } else {
                        //beforeChar == '0' 3-9
                        dp[i] = dp[i - 2] + 9 - 1;
                    }
                } else if (currentChar == '0') {
                    if (beforeChar == '1' || beforeChar == '2') {
                        dp[i] = dp[i - 2];
                    } else if (beforeChar == '*') {
                        dp[i] = dp[i - 2] + 1;
                    } else {
                        //beforeChar == '0' 3-9
                        return 0;
                    }
                } else {
                    // 1,2,3,4,5,6,7,8,9
                    if (beforeChar == '*') {
                        if (currentChar - '0' <= 6) {
                            dp[i] = dp[i - 2] + 1 + dp[i - 1];
                        } else {
                            dp[i] = dp[i - 2] + dp[i - 1];
                        }
                    } else {
                        int value = (beforeChar - '0') * 10 + (currentChar - '0');
                        if (value > 10 && value <= 26) {
                            dp[i] = dp[i - 2] + dp[i - 1];
                        } else {
                            dp[i] = dp[i - 1];
                        }
                    }
                }
            }

            Utils.printTable(dp);
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

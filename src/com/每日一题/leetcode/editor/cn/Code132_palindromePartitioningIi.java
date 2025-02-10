package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Collections;

/**
 * [每日一题] 2024-08-02 16:00:58
 * 题目名称: 分割回文串 II
 * 题目类型:
 * 思考:
 */
public class Code132_palindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new Code132_palindromePartitioningIi().new Solution();


        int aab = solution.minCut("abbab");
        System.out.println(aab);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {

            int[] dp = new int[s.length() + 1];

            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    String string = s.substring(j, i);
                    if (isReverse(string)) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                        if (dp[i] == 1){
                            break;
                        }
                    }
                }

            }

//            Utils.printTable(dp);
            return dp[dp.length - 1] - 1;

        }

        private boolean isReverse(String s) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

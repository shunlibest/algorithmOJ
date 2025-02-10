package com.每日一题.leetcode.editor.cn;

import com.Main;
import com.Utils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [每日一题] 2024-08-08 17:07:28
 * 题目名称: 最长字符串链
 * 题目类型:
 * 思考:
 */


public class Code1048_longestStringChain {
    public static void main(String[] args) {
        Solution solution = new Code1048_longestStringChain().new Solution();
        String[] i0 = {"x", "pu"};
//        Object i1 = {"abcd","dbqca"};
        int i = solution.longestStrChain(i0);
        System.out.println(i);

//        boolean wordChain = solution.isWordChain("ab", "xab");
//        System.out.println(wordChain);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestStrChain(String[] words) {
            int[] dp = new int[words.length];

            Arrays.sort(words, Comparator.comparingInt(String::length));
//            Utils.printTable(words);
//            for (String s : words) {
//                System.out.println(s);
//            }
            int max = 1;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (isWordChain(words[j], words[i])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        max = Math.max(max, dp[i]);
                    }
                }
            }

//            Utils.printTable(dp);
            return max;
        }

        private boolean isWordChain(String a, String b) {
            if (a.length() + 1 != b.length()) {
                return false;
            }
            int addOne = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i + addOne)) {
                    continue;
                }
                i--;
                addOne++;

                if (addOne >= 2) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

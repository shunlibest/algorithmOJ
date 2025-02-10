package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-08-02 15:39:09
 * 题目名称: 单词拆分
 * 题目类型:
 * 思考:
 */
public class Code139_wordBreak {
    public static void main(String[] args) {
        Solution solution = new Code139_wordBreak().new Solution();
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
//        wordDict.add("code");

        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean[] dp = new boolean[s.length() + 1];


            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (String word : wordDict) {
                    int length = word.length();
                    dp[i] = i - length >= 0 && dp[i - length] && s.substring(i - length, i).equals(word);
                    if (dp[i]) {
                        break;
                    }
                }
            }
//            Utils.printTable(dp);

            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

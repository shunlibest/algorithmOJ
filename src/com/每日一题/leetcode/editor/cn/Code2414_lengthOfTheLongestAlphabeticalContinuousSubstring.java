package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-09-19 10:31:02
 * 题目名称: 最长的字母序连续子字符串的长度
 * 题目类型:
 * 思考:
 */


public class Code2414_lengthOfTheLongestAlphabeticalContinuousSubstring {
    public static void main(String[] args) {
        Solution solution = new Code2414_lengthOfTheLongestAlphabeticalContinuousSubstring().new Solution();
        Object i0 = "abacaba";
        int abacaba = solution.longestContinuousSubstring("abcde");
        System.out.println(abacaba);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestContinuousSubstring(String s) {
            int[] length = new int[s.length()];
            length[0] = 1;
            int max = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) - s.charAt(i - 1) == 1) {
                    length[i] = length[i - 1] + 1;
                } else {
                    length[i] = 1;
                }
                max = Math.max(max, length[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

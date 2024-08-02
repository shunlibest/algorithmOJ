package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-25 15:26:04
 * 题目名称: 检测大写字母
 * 题目类型:
 * 思考:
 */
public class Code520_detectCapital {
    public static void main(String[] args) {
        Solution solution = new Code520_detectCapital().new Solution();
        boolean res = solution.detectCapitalUse("fF");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
                return true;
            }
            if (!isUpper(word.charAt(0))) {
                return false;
            }

            for (int i = 1; i < word.length(); i++) {
                if (isUpper(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        private boolean isUpper(char c) {
            return c >= 'A' && c <= 'Z';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

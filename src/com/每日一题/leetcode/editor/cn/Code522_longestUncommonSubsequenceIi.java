package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-18 14:25:23
 * 题目名称: 最长特殊序列 II
 * 题目类型:
 * 思考:
 */
public class Code522_longestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution solution = new Code522_longestUncommonSubsequenceIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            int maxLength = 0;
            int maxLengthIndex = 0;

            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() > maxLength) {
                    maxLength = strs[i].length();
                    maxLengthIndex = i;
                }
            }

            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals(strs[maxLengthIndex]) && i != maxLengthIndex) {
                    return -1;
                }
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

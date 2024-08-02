package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-18 13:51:37
 * 题目名称: 最长特殊序列 Ⅰ
 * 题目类型:
 * 思考:
 */
public class Code521_longestUncommonSubsequenceI {
    public static void main(String[] args) {
        Solution solution = new Code521_longestUncommonSubsequenceI().new Solution();

        int luSlength = solution.findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef");
        System.out.println(luSlength);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String a, String b) {
            if (a.equals(b)) {
                return -1;
            }
            return Math.max(a.length(), b.length());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

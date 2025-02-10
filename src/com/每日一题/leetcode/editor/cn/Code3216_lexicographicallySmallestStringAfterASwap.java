package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-10-30 14:00:34
 * 题目名称: 交换后字典序最小的字符串
 * 题目类型:
 * 思考:
 */


public class Code3216_lexicographicallySmallestStringAfterASwap {
    public static void main(String[] args) {
        Solution solution = new Code3216_lexicographicallySmallestStringAfterASwap().new Solution();
        String i0 = "53";
        String smallestString = solution.getSmallestString(i0);
        System.out.println(smallestString);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getSmallestString(String s) {

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i + 1] < chars[i] && (chars[i + 1] - chars[i]) % 2 == 0) {
                    char temp = chars[i];
                    chars[i] = chars[i + 1];
                    chars[i + 1] = temp;
                    return String.valueOf(chars);
                }
            }
            return s;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-19 11:14:21
 * 题目名称: 字符串转换整数 (atoi)
 * 题目类型:
 * 思考:
 */
public class Code8_stringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new Code8_stringToIntegerAtoi().new Solution();

        int i = solution.myAtoi("9223372036854775808");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            char[] chars = s.trim().toCharArray();
            if (chars.length == 0) {
                return 0;
            }
            boolean positive = true;
            int index = 0;
            // step1: 获取正负
            if (chars[index] == '+') {
                index++;
            } else if (chars[index] == '-') {
                positive = false;
                index++;
            }

            // step2: 跳过前置0
            while (index < chars.length && chars[index] == '0') {
                index++;
            }

            long result = 0;
            for (int i = index; i < chars.length; i++) {
                int value = chars[i] - '0';
                if (value > 9 || value < 0) {
                    break;
                }
                result = result * 10 + value;
                if (result > Integer.MAX_VALUE) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            return (int) (positive ? result : -result);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

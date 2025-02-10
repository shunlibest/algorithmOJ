package com.每日一题.leetcode.editor.cn;

import java.util.Stack;

/**
 * [每日一题] 2024-10-18 17:13:00
 * 题目名称: 字符串解码
 * 题目类型:
 * 思考:
 */


public class Code394_decodeString {
    public static void main(String[] args) {
        Solution solution = new Code394_decodeString().new Solution();
        String i0 = "3[a]2[bc]";
        Object i1 = "2{abc}3{cd}ef";
        String s = solution.decodeString("abc3[cd]xyz");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {

            char[] chars = s.toCharArray();

            StringBuilder sb = new StringBuilder();
            int num = 0;
            int leftCount = 0;
            int startIndex = 0;
            for (int i = 0; i < chars.length; i++) {
                if (num == 0 && !isDigit(chars[i])) {
                    sb.append(chars[i]);
                }

                if (isDigit(chars[i]) && leftCount == 0) {
                    num = num * 10 + chars[i] - '0';
                }

                if (chars[i] == '[') {
                    if (leftCount == 0) {
                        startIndex = i;
                    }
                    leftCount++;
                }

                if (chars[i] == ']') {
                    leftCount--;
                    if (leftCount == 0) {
                        String str = decodeString(s.substring(startIndex + 1, i));

                        for (int repeat = 0; repeat < num; repeat++) {
                            sb.append(str);
                        }
                        num = 0;
                    }
                }


            }

            return sb.toString();

        }

        private boolean isDigit(char c) {
            return c >= '0' && c <= '9';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

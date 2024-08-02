package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-19 10:40:23
 * 题目名称: Z 字形变换
 * 题目类型:
 * 思考:
 */
public class Code6_zigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Code6_zigzagConversion().new Solution();

        String paypalishiring = solution.convert("A", 1);

        System.out.println(paypalishiring);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {

            StringBuilder[] result = new StringBuilder[numRows];

            for (int i = 0; i < result.length; i++) {
                result[i] = new StringBuilder();
            }

            char[] chars = s.toCharArray();

            int round = (numRows - 2) * 2 + 2;
            if (numRows == 1) {
                round = 1;
            }
            for (int i = 0; i < chars.length; i++) {

                int roundIndex = i % round;

                if (roundIndex < numRows) {
                    result[roundIndex].append(chars[i]);
                } else {
                    result[round - roundIndex].append(chars[i]);
                }
            }

            StringBuilder res = new StringBuilder();

            for (StringBuilder sb : result) {
                res.append(sb);
            }


            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

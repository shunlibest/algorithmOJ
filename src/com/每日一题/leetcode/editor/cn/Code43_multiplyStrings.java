package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2025-02-11 10:04:08
 * 题目名称: 字符串相乘
 * 题目类型:
 * 思考:
 */


public class Code43_multiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Code43_multiplyStrings().new Solution();
//        S i0 = "2";
//        Object i1 = "123";
        String multiply = solution.multiply("123", "456");

        System.out.println(multiply);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            char[] num1Char = num1.toCharArray();
            char[] num2Char = num2.toCharArray();

            int[] result = new int[num1Char.length + num2Char.length]; // 存储乘积的数组

            for (int i = num1Char.length - 1; i >= 0; i--) {
                for (int j = num2Char.length - 1; j >= 0; j--) {

                    int mul = (num1Char[i] - '0') * (num2Char[j] - '0');
//                    result[i + j] += mul;

                    int sum = mul + result[i + j + 1]; // 加上当前位置的已有值

                    result[i + j + 1] = sum %10;
                    result[i + j] += sum / 10;   // 进位

                }
            }

            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                // 避免添加前导零
                if (!(sb.length() == 0 && num == 0)) {
                    sb.append(num);
                }
            }


            return sb.toString();

//            for (int i = 0; i < num1Char.length; i++) {
//                for (int j = 0; j < num2Char.length; j++) {
//
//                }
//            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

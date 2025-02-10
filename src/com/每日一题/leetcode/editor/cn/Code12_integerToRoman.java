package com.每日一题.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2024-08-16 11:15:50
 * 题目名称: 整数转罗马数字
 * 题目类型:
 * 思考:
 */


public class Code12_integerToRoman {
    public static void main(String[] args) {
        Solution solution = new Code12_integerToRoman().new Solution();
        Object i0 = 3749;
        Object i1 = 1994;
        solution.intToRoman(3749);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
            String numString = String.valueOf(num);

            //String[] roms = {"M",  "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
            // int[] values = {1000, 900, 500, 400, 100, 90, 50,  40,  10,  9,  5,  4,   1};
            Map<Integer, String> map = new HashMap<>();
            map.put(900, "CM");
            map.put(400, "CD");
            map.put(90, "XC");
            map.put(40, "XL");
            map.put(9, "IX");
            map.put(4, "IV");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numString.length(); i++) {
                int value = (numString.charAt(i) - '0') * (int) Math.pow(10, numString.length() - i - 1);

                if (map.containsKey(value)){
                    sb.append(map.get(value));
                    continue;
                }

                while (value >= 1000) {
                    sb.append("M");
                    value = value - 1000;
                }

                while (value >= 500) {
                    sb.append("D");
                    value = value - 500;
                }

                while (value >= 100) {
                    sb.append("C");
                    value = value - 100;
                }

                while (value >= 50) {
                    sb.append("L");
                    value = value - 50;
                }

                while (value >= 10) {
                    sb.append("X");
                    value = value - 10;
                }

                while (value >= 5) {
                    sb.append("V");
                    value = value - 5;
                }
                while (value >= 1) {
                    sb.append("I");
                    value = value - 1;
                }

//                System.out.println(value);
            }

//            System.out.println(sb);

//            for (int i = 1; ; i++) {
//                int n = num - (num % (int) Math.pow(10, i));
//
//                if (n == 0) {
//                    break;
//                }
//
//                System.out.println(n);
//            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Stack;

/**
 * [每日一题] 2025-06-06 11:13:57
 * 题目名称: 使用机器人打印字典序最小的字符串
 * 题目类型:
 * 思考:
 */


public class Code2434_usingARobotToPrintTheLexicographicallySmallestString {
    public static void main(String[] args) {
        Solution solution = new Code2434_usingARobotToPrintTheLexicographicallySmallestString().new Solution();
        Object i0 = "zza";
        Object i1 = "bdda";
        solution.robotWithString("bdda");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String robotWithString(String s) {

            char[] charArray = s.toCharArray();

            int[] minChar = new int[charArray.length];

            minChar[charArray.length - 1] = charArray[charArray.length - 1];
            for (int i = charArray.length - 2; i >= 0; i--) {
                minChar[i] = Math.min(minChar[i + 1], charArray[i]);
            }

            Utils.printTable(minChar);

            Stack<Integer> stack = new Stack<>();

            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

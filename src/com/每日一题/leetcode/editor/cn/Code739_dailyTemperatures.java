package com.每日一题.leetcode.editor.cn;

import com.Utils;
import javafx.util.Pair;

import java.util.Stack;

/**
 * [每日一题] 2024-10-21 15:40:27
 * 题目名称: 每日温度
 * 题目类型:
 * 思考:
 */


public class Code739_dailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new Code739_dailyTemperatures().new Solution();
        int[] i0 = {73, 74, 75, 71, 69, 72, 76, 73};
//        Object i1 = {30,60,90};
        int[] ints = solution.dailyTemperatures(i0);
        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Pair<Integer, Integer>> stack = new Stack<>();
            int[] res = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && stack.peek().getKey() < temperatures[i]) {
                    Pair<Integer, Integer> topItem = stack.pop();
                    res[topItem.getValue()] = i - topItem.getValue();
                }
                stack.push(new Pair<>(temperatures[i], i));

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

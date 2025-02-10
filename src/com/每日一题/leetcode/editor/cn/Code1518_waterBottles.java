package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-09 16:40:43
 * 题目名称: 换水问题
 * 题目类型:
 * 思考:
 */


public class Code1518_waterBottles {
    public static void main(String[] args) {
        Solution solution = new Code1518_waterBottles().new Solution();
//        Object i0 = 9;
//        Object i1 = 15;
        int i = solution.numWaterBottles(15, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {

            int sum = numBottles;
            int emptyBottles = numBottles;

            while (emptyBottles >= numExchange) {
                sum += emptyBottles / numExchange;

                emptyBottles = emptyBottles / numExchange + emptyBottles % numExchange;
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

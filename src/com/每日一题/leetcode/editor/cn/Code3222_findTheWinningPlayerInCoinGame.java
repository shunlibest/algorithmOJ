package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-11-05 11:33:04
 * 题目名称: 求出硬币游戏的赢家
 * 题目类型:
 * 思考:
 */


public class Code3222_findTheWinningPlayerInCoinGame {
    public static void main(String[] args) {
        Solution solution = new Code3222_findTheWinningPlayerInCoinGame().new Solution();

        String s = solution.losingPlayer(4, 11);

        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String losingPlayer(int x, int y) {
            String A = "Alice";
            String B = "Bob";

            if (x < y / 4) {

                if (x % 2 == 1) {
                    return A;
                } else {
                    return B;
                }

            } else {
                if (y % 8 < 4) {
                    return B;
                } else {
                    return A;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-22 17:38:02
 * 题目名称: 构造最长的新字符串
 * 题目类型:
 * 思考:
 */
public class Code2745_constructTheLongestNewString {
    public static void main(String[] args) {
        Solution solution = new Code2745_constructTheLongestNewString().new Solution();

        int i = solution.longestString(2, 5, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestString(int x, int y, int z) {

            int maxLength = (x + y + z) * 2;

            int[][][][] dp = new int[x][y][z][3];


            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    for (int k = 0; k < dp[0][0].length; k++) {


                        dp[i][j][k][0] = 2 + Math.max(dp[i - 1][j][k][1], dp[i - 1][j][k][2]);
                    }
                }
            }


            //
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

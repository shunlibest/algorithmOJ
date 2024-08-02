package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-03 10:14:50
 * 题目名称: 一和零
 * 题目类型:
 * 思考:
 */
public class Code474_onesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new Code474_onesAndZeroes().new Solution();
        String[] array = {"10", "0001", "111001", "1", "0"};
        int maxForm = solution.findMaxForm(array, 3, 4);
        System.out.println(maxForm);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            Info[] strList = new Info[strs.length + 1];
            strList[0] = new Info(0, 0);
            for (int i = 0; i < strs.length; i++) {
                int zeroCount = 0;
                int oneCount = 0;
                for (int j = 0; j < strs[i].length(); j++) {
                    if (strs[i].charAt(j) == '0') {
                        zeroCount++;
                    } else {
                        oneCount++;
                    }
                }
                strList[i + 1] = new Info(zeroCount, oneCount);
            }


            int[][][] dp = new int[strList.length][m + 1][n + 1];

            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    for (int k = 0; k < dp[0][0].length; k++) {
                        if (i == 0 && j == 0 && k == 0) {
                            dp[i][j][k] = 0;
                            continue;
                        }

                        int select = 0;
                        if (i - 1 >= 0 && j - strList[i].zero >= 0 && k - strList[i].one >= 0) {
                            select = getValue(dp, i - 1, j - strList[i].zero, k - strList[i].one) + 1;
                        }
//                        if (j >= strList[i].zero && k >= strList[i].one) {
//                        }


                        dp[i][j][k] = Math.max(getValue(dp, i - 1, j, k), select);

                        max = Math.max(max, dp[i][j][k]);
                    }
                }
            }

            return max;
        }


        int getValue(int[][][] dp, int x, int y, int z) {
            if (x < 0 || y < 0 || z < 0) {
                return 0;
            }
            return dp[x][y][z];
        }

        public class Info {
            public int one;
            public int zero;

            public Info(int zero, int one) {
                this.one = one;
                this.zero = zero;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

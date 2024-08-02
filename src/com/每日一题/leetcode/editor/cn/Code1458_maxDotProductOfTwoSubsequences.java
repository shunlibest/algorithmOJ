package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-18 15:21:22
 * 题目名称: 两个子序列的最大点积
 * 题目类型:
 * 思考:
 */
public class Code1458_maxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        Solution solution = new Code1458_maxDotProductOfTwoSubsequences().new Solution();

//        int[] a = {5, -4, -3};
//        int[] b = {-4, -3, 0, -4, 2};

        int[] a = {-1, -1};
        int[] b = {1, 1};
        int i = solution.maxDotProduct(a, b);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDotProduct(int[] nums1, int[] nums2) {


            int[][] dp = new int[nums1.length + 1][nums2.length + 1];

            int sum = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = 0;
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }


                    int muti = nums1[i - 1] * nums2[j - 1];

                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                    if ( dp[i][j] <=  dp[i - 1][j - 1] + muti) {
                        dp[i][j] = dp[i - 1][j - 1] + muti;
                        sum = Integer.MAX_VALUE;
                    }
                    sum = Math.max(sum, muti);

                }
            }

//            Utils.printTable(dp);

            return Math.min(dp[dp.length - 1][dp[0].length - 1], sum);
//            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

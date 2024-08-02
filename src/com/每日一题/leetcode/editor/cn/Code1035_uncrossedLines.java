package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-18 15:09:23
 * 题目名称: 不相交的线
 * 题目类型:
 * 思考:
 */
public class Code1035_uncrossedLines {
    public static void main(String[] args) {


        Solution solution = new Code1035_uncrossedLines().new Solution();

        int[] a = {1, 3, 7, 1, 7, 5};
        int[] b = {1, 9, 2, 5, 1};

//        int[] a = {1};
//        int[] b = {1};
        int i = solution.maxUncrossedLines(a, b);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {

            int[][] dp = new int[nums1.length + 1][nums2.length + 1];

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

                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }


                }
            }

//            Utils.printTable(dp);
            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

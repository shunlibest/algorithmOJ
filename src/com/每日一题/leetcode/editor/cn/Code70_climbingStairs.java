package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-26 16:39:10
 * 题目名称: 爬楼梯
 * 题目类型:
 * 思考:
 */
public class Code70_climbingStairs {
    public static void main(String[] args) {
        Solution solution = new Code70_climbingStairs().new Solution();
        int i = solution.climbStairs(3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

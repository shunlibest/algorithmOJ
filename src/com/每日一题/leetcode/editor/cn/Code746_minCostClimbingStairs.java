package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-26 16:53:25
 * 题目名称: 使用最小花费爬楼梯
 * 题目类型:
 * 思考:
 */
public class Code746_minCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Code746_minCostClimbingStairs().new Solution();
        int[] array = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = solution.minCostClimbingStairs(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp[i]
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];

            dp[0] = 0;
            dp[1] = 0;

            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

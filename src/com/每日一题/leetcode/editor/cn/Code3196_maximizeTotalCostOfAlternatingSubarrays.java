package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-02 17:26:02
 * 题目名称: 最大化子数组的总成本
 * 题目类型:
 * 思考:
 */
public class Code3196_maximizeTotalCostOfAlternatingSubarrays {
    public static void main(String[] args) {
        Solution solution = new Code3196_maximizeTotalCostOfAlternatingSubarrays().new Solution();


        int[] array = {1, -2, 3, 4};
        long l = solution.maximumTotalCost(array);
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTotalCost(int[] nums) {
            long[] dp = new long[nums.length];

            if (dp.length == 1) {
                return nums[0];
            }

            dp[0] = nums[0];
            dp[1] = Math.max(nums[0] + nums[1], nums[0] - nums[1]);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], dp[i - 2] + nums[i - 1] - nums[i]);
            }

//            Utils.printTable(dp);

            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

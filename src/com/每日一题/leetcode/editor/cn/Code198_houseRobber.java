package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 10:23:57
 * 题目名称: 打家劫舍
 * 题目类型:
 * 思考:
 */
public class Code198_houseRobber {
    public static void main(String[] args) {
        Solution solution = new Code198_houseRobber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[dp.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

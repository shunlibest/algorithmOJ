package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 13:48:34
 * 题目名称: 打家劫舍 II
 * 题目类型:
 * 思考:
 */
public class Code213_houseRobberIi {
    public static void main(String[] args) {
        Solution solution = new Code213_houseRobberIi().new Solution();
        int[] array = {1, 2, 1, 1};
        int rob = solution.rob(array);
        System.out.println(rob);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dp1 = new int[nums.length];

            // case1: 偷第一家
            dp1[0] = nums[0];
            dp1[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < dp1.length - 1; i++) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            }

            // case2: 不偷第一家
            int[] dp2 = new int[nums.length];
            dp2[0] = 0;
            dp2[1] = nums[1];
            for (int i = 2; i < dp2.length; i++) {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
            }
//            System.out.println(dp1[dp1.length - 2]);
//            System.out.println(dp2[dp2.length - 1]);
            return Math.max(dp1[dp1.length - 2], dp2[dp2.length - 1]);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

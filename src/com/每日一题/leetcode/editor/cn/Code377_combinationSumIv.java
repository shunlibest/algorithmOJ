package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-26 16:59:52
 * 题目名称: 组合总和 Ⅳ
 * 题目类型:
 * 思考:
 */
public class Code377_combinationSumIv {
    public static void main(String[] args) {
        Solution solution = new Code377_combinationSumIv().new Solution();
        int[] array = {1, 2, 3};
        int i = solution.combinationSum4(array, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int combinationSum4(int[] nums, int target) {

            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    int form = i - nums[j];
                    if (form >= 0) {
                        dp[i] += dp[form];
                    }
                }

            }
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

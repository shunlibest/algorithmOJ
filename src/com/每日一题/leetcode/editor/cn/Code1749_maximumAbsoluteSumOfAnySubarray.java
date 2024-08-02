package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 14:57:53
 * 题目名称: 任意子数组和的绝对值的最大值
 * 题目类型:
 * 思考:
 */
public class Code1749_maximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        Solution solution = new Code1749_maximumAbsoluteSumOfAnySubarray().new Solution();
        int[] array = {2, -5, 1, -4, 3, -2};
        int i = solution.maxAbsoluteSum(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAbsoluteSum(int[] nums) {

            int[] positiveMax = new int[nums.length];
            int[] negMax = new int[nums.length];

            positiveMax[0] = nums[0];
            negMax[0] = nums[0];
            int positive = Math.max(positiveMax[0], 0);
            int neg = Math.min(positiveMax[0], 0);
            for (int i = 1; i < nums.length; i++) {
                positiveMax[i] = Math.max(positiveMax[i - 1], 0) + nums[i];
                negMax[i] = Math.min(negMax[i - 1], 0) + nums[i];

                positive = Math.max(positive, positiveMax[i]);
                neg = Math.min(neg, negMax[i]);
            }
//            System.out.println(positive);
//            System.out.println(neg);
            return Math.max(positive, -neg);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

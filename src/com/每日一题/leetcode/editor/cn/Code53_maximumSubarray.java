package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 14:09:36
 * 题目名称: 最大子数组和
 * 题目类型:
 * 思考:
 */
public class Code53_maximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Code53_maximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int[] sumValue = new int[nums.length];
            sumValue[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sumValue[i] = Math.max(sumValue[i - 1], 0) + nums[i];
                max = Math.max(max, sumValue[i]);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

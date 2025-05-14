package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-03-11 10:35:26
 * 题目名称: 数组美丽值求和
 * 题目类型:
 * 思考:
 */


public class Code2012_sumOfBeautyInTheArray {
    public static void main(String[] args) {
        Solution solution = new Code2012_sumOfBeautyInTheArray().new Solution();
//        int[] i1 = {1, 2, 3};
        int[] i1 = {2,4,6,4};
        int i = solution.sumOfBeauties(i1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfBeauties(int[] nums) {


            int[] maxPreSum = new int[nums.length];
            int[] minSubSum = new int[nums.length];

            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                maxPreSum[i] = max;
            }
            int min = Integer.MAX_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                min = Math.min(min, nums[i]);
                minSubSum[i] = min;
            }

            int count = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (maxPreSum[i - 1] < nums[i] && nums[i] < minSubSum[i + 1]) {
                    count += 2;
                    continue;
                }

                if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    count++;
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

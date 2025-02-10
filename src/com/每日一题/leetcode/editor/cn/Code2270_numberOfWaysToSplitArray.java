package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2025-01-13 10:09:48
 * 题目名称: 分割数组的方案数
 * 题目类型:
 * 思考:
 */


public class Code2270_numberOfWaysToSplitArray {
    public static void main(String[] args) {
        Solution solution = new Code2270_numberOfWaysToSplitArray().new Solution();
        int[] i0 = {10, 4, -8, 7};
        int i = solution.waysToSplitArray(i0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToSplitArray(int[] nums) {
            long[] preSum = new long[nums.length];
            long[] suffixSum = new long[nums.length];

            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            suffixSum[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                suffixSum[i] = suffixSum[i + 1] + nums[i];
            }

//            Utils.printTable(preSum);
//            Utils.printTable(suffixSum);

            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (preSum[i] >= suffixSum[i + 1]) {
                    count++;
                }
            }


            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

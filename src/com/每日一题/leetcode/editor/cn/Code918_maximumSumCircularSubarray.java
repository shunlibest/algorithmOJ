package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-06-27 15:54:21
 * 题目名称: 环形子数组的最大和
 * 题目类型:
 * 思考:
 */
public class Code918_maximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new Code918_maximumSumCircularSubarray().new Solution();
        int i = solution.maxSubarraySumCircular(new int[]{-3, -1, -2});

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {

            // int maxS = Integer.MIN_VALUE; // 最大子数组和，不能为空
            //        int minS = 0; // 最小子数组和，可以为空
            //        int maxF = 0, minF = 0, sum = 0;
            //        for (int x : nums) {
            //            // 以 nums[i-1] 结尾的子数组选或不选（取 max）+ x = 以 x 结尾的最大子数组和
            //            maxF = Math.max(maxF, 0) + x;
            //            maxS = Math.max(maxS, maxF);
            //            // 以 nums[i-1] 结尾的子数组选或不选（取 min）+ x = 以 x 结尾的最小子数组和
            //            minF = Math.min(minF, 0) + x;
            //            minS = Math.min(minS, minF);
            //            sum += x;
            //        }
            //        return sum == minS ? maxS : Math.max(maxS, sum - minS);
            //
            //作者：灵茶山艾府
            //链接：https://leetcode.cn/problems/maximum-sum-circular-subarray/solutions/2351107/mei-you-si-lu-yi-zhang-tu-miao-dong-pyth-ilqh/
            //来源：力扣（LeetCode）
            //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


            int maxSum = 0;
            int maxF = Integer.MIN_VALUE;

            int minF = 0;
            int minSum = 0;

            for (int n : nums) {
                maxF = Math.max(maxF, 0) + n;
                maxSum = Math.max(maxSum, maxF);

                minF = Math.min(minF, 0) + n;
                minSum = Math.min(minSum, minF);
            }
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }

            return  sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

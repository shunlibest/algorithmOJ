package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

/**
 * [每日一题] 2024-10-16 15:11:02
 * 题目名称: 最小元素和最大元素的最小平均值
 * 题目类型:
 * 思考:
 */


public class Code3194_minimumAverageOfSmallestAndLargestElements {
    public static void main(String[] args) {
        Solution solution = new Code3194_minimumAverageOfSmallestAndLargestElements().new Solution();
        int[] i0 = {7, 8, 3, 4, 15, 13, 4, 1};
//        Object i1 = {1,2,3,7,8,9};
        double v = solution.minimumAverage(i0);

        System.out.println(v);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double minimumAverage(int[] nums) {
            Arrays.sort(nums);

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length / 2; i++) {

                int sum = nums[i] + nums[nums.length - 1 - i];

                result = Math.min(result, sum);


            }

            return result / 2.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

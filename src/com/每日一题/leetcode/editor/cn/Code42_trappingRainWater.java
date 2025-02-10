package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-09-03 14:07:37
 * 题目名称: 接雨水
 * 题目类型:
 * 思考:
 */


public class Code42_trappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Code42_trappingRainWater().new Solution();
        int[] i0 = {4, 2, 3};
        int trap = solution.trap(i0);
        System.out.println(trap);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {

            int leftMaxIndex = height[0];
            int maxHeightIndex = -1;
            int maxHeight = -1;

            for (int i = 0; i < height.length; i++) {
                if (height[i] > maxHeight) {
                    maxHeight = height[i];
                    maxHeightIndex = i;
                }
            }

            int sum = 0;
            for (int i = 0; i < maxHeightIndex; i++) {
                leftMaxIndex = Math.max(leftMaxIndex, height[i]);
                sum += leftMaxIndex - height[i];
            }

            int rightMaxIndex = height[height.length - 1];
            for (int i = height.length - 1; i > maxHeightIndex; i--) {
                rightMaxIndex = Math.max(rightMaxIndex, height[i]);
                sum += rightMaxIndex - height[i];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

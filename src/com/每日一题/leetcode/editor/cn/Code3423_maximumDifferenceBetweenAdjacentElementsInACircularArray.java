package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-06-12 10:28:26
 * 题目名称: 循环数组中相邻元素的最大差值
 * 题目类型:
 * 思考:
 */


public class Code3423_maximumDifferenceBetweenAdjacentElementsInACircularArray {
    public static void main(String[] args) {
        Solution solution = new Code3423_maximumDifferenceBetweenAdjacentElementsInACircularArray().new Solution();
        int[] i0 = {1, 2, 4};
        int i = solution.maxAdjacentDistance(i0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAdjacentDistance(int[] nums) {

            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, Math.abs(nums[i] - nums[(i + 1) % nums.length]));
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

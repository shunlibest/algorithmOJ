package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-16 13:40:11
 * 题目名称: 找到两个数组中的公共元素
 * 题目类型:
 * 思考:
 */
public class Code2956_findCommonElementsBetweenTwoArrays {
    public static void main(String[] args) {
        Solution solution = new Code2956_findCommonElementsBetweenTwoArrays().new Solution();

        int[] nums1 = {3, 4, 2, 3};
        int[] nums2 = {1, 5};
        int[] intersectionValues = solution.findIntersectionValues(nums1, nums2);
        System.out.println(Arrays.toString(intersectionValues));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findIntersectionValues(int[] nums1, int[] nums2) {
            boolean[] num1Set = new boolean[100];
            boolean[] num2Set = new boolean[100];
            for (int num : nums1) {
                num1Set[num - 1] = true;
            }
            for (int num : nums2) {
                num2Set[num - 1] = true;
            }

            int num1Count = 0;
            int num2Count = 0;
            for (int num : nums1) {
                num1Count += getValue(num2Set, num - 1);
            }

            for (int num : nums2) {
                num2Count += getValue(num1Set, num - 1);
            }
            return new int[]{num1Count, num2Count};
        }

        int getValue(boolean[] array, int index) {
            if (index < 0 || index >= array.length) {
                return 0;
            }
            return array[index] ? 1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

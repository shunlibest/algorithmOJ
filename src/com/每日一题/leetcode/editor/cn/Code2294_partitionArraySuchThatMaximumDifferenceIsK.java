package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2025-06-19 10:40:46
 * 题目名称: 划分数组使最大差为 K
 * 题目类型:
 * 思考:
 */


public class Code2294_partitionArraySuchThatMaximumDifferenceIsK {
    public static void main(String[] args) {
        Solution solution = new Code2294_partitionArraySuchThatMaximumDifferenceIsK().new Solution();
        int[] i0 = {3, 6, 1, 2, 5};
        int[] i1 = {1, 2, 3};
        int[] i2 = {2, 2, 4, 5};
        int i = solution.partitionArray(i0, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);

            int min = nums[0];
            int count = 1;
            for (int num : nums) {
                if (num <= min + k) {
                    continue;
                } else {
//                    System.out.println(num);
                    min = num;
                    count++;
                }
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

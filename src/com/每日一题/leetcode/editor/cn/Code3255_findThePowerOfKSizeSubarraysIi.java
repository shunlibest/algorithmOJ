package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-11-07 10:24:07
 * 题目名称: 长度为 K 的子数组的能量值 II
 * 题目类型:
 * 思考:
 */


public class Code3255_findThePowerOfKSizeSubarraysIi {
    public static void main(String[] args) {
        Solution solution = new Code3255_findThePowerOfKSizeSubarraysIi().new Solution();
        int[] i0 = {1, 2, 3, 4, 3, 2, 5};
//        Object i1 = {2,2,2,2,2};
//        Object i2 = {3,2,3,2,3,2};
        int[] ints = solution.resultsArray(i0, 3);
        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] resultsArray(int[] nums, int k) {

            int[] sumCount = new int[nums.length];

            for (int i = sumCount.length - 2; i >= 0; i--) {
                if (nums[i + 1] - nums[i] == 1) {
                    sumCount[i] = sumCount[i + 1] + 1;
                } else {
                    sumCount[i] = 0;
                }
            }

            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < sumCount.length - k + 1; i++) {

                if (sumCount[i] > k - 2) {
                    res[i] = nums[i + k - 1];
                } else {
                    res[i] = -1;
                }
            }

//            Utils.printTable(sumCount);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

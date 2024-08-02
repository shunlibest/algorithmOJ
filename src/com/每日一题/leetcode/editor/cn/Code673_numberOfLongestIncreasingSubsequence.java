package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-19 15:13:44
 * 题目名称: 最长递增子序列的个数
 * 题目类型:
 * 思考:
 */
public class Code673_numberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code673_numberOfLongestIncreasingSubsequence().new Solution();
        int[] array = {1, 2, 6, 1, 2, 6, 3};
        int numberOfLIS = solution.findNumberOfLIS(array);

        System.out.println(numberOfLIS);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {

            int[] dpLength = new int[nums.length];
            int[] dpCount = new int[nums.length];

            for (int i = 0; i < dpLength.length; i++) {

                if (i == 0) {
                    dpLength[0] = 1;
                    continue;
                }

                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        // 递增
                        if (dpLength[j] + 1 > dpLength[i]) {
                            dpLength[i] = dpLength[j];
                            dpCount[i] = dpCount[j];
                        } else if (dpLength[j] + 1 == dpLength[i]) {

                            dpCount[i] = dpCount[i] + dpCount[j];

                        }

                    }


                }


            }

//            Utils.printTable(dp);
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

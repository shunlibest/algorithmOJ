package com.每日一题.leetcode.editor.cn;

import java.util.List;

/**
 * [每日一题] 2024-07-19 16:10:13
 * 题目名称: 将三个组排序
 * 题目类型:
 * 思考:
 */
public class Code2826_sortingThreeGroups {
    public static void main(String[] args) {
        Solution solution = new Code2826_sortingThreeGroups().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(List<Integer> nums) {

            int[] dp = new int[nums.size()];

            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums.get(i) >= nums.get(j)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int max = 1;
            for (int num : dp) {
                max = Math.max(max, num);
            }

            return nums.size() - max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

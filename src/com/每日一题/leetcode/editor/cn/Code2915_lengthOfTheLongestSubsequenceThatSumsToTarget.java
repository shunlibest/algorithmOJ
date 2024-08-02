package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2024-07-02 13:52:11
 * 题目名称: 和为目标值的最长子序列的长度
 * 题目类型:
 * 思考:
 */
public class Code2915_lengthOfTheLongestSubsequenceThatSumsToTarget {
    public static void main(String[] args) {
        Solution solution = new Code2915_lengthOfTheLongestSubsequenceThatSumsToTarget().new Solution();

        Integer[] array = {1, 1, 5, 4, 5};
        int i = solution.lengthOfLongestSubsequence(Arrays.asList(array), 3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            List<Integer> numList = new ArrayList<>(nums.size() + 1);
            numList.add(0, 0);
            numList.addAll(nums);

            int[][] dp = new int[numList.size()][target + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    int notSelect = getValue(dp, i - 1, j);
                    int select = getValue(dp, i - 1, j - numList.get(i)) + 1;
                    if (select == 0) {
                        select = -1;
                    }
                    dp[i][j] = Math.max(notSelect, select);
//                    dp[i][j] = Math.max(dp[i][j], 0);

                }
            }


            Utils.printTable(dp);

            return dp[dp.length - 1][dp[0].length - 1];

        }

        private int getValue(int[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return -1;
            }
            return dp[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

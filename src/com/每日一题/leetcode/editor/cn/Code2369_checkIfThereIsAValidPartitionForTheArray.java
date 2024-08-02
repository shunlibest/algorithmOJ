package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-02 14:15:09
 * 题目名称: 检查数组是否存在有效划分
 * 题目类型:
 * 思考:
 */
public class Code2369_checkIfThereIsAValidPartitionForTheArray {
    public static void main(String[] args) {
        Solution solution = new Code2369_checkIfThereIsAValidPartitionForTheArray().new Solution();


        int[] array = {4, 4, 4, 5, 6};
        boolean b = solution.validPartition(array);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPartition(int[] nums) {
            boolean[] dp = new boolean[nums.length];

            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[i] = false;
                    continue;
                }
                if (i == 1) {
                    dp[i] = nums[i] == nums[i - 1];
                    continue;
                }

                if (i == 2) {
                    dp[i] |= dp[i - 2] && nums[i] == nums[i - 1];
                    dp[i] |= nums[i] == nums[i - 1] && nums[i] == nums[i - 2];
                    dp[i] |= nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2;
                    continue;
                }


                dp[i] |= dp[i - 2] && nums[i] == nums[i - 1];
                dp[i] |= dp[i - 3] && nums[i] == nums[i - 1] && nums[i] == nums[i - 2];
                dp[i] |= dp[i - 3] && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2;
            }

//            Utils.printTable(dp);

            return dp[dp.length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-22 16:36:50
 * 题目名称: 删掉一个元素以后全为 1 的最长子数组
 * 题目类型:
 * 思考:
 */
public class Code1493_longestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        Solution solution = new Code1493_longestSubarrayOf1sAfterDeletingOneElement().new Solution();


        int[] array = {0, 0, 0};
        int i = solution.longestSubarray(array);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums) {


            int[][] dp = new int[nums.length][2];


            // 0: 删掉0次
            // 1: 删掉1个0之后
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    if (nums[0] == 0) {
                        dp[0][0] = 0;
                        dp[0][1] = 0;
                    } else {
                        dp[0][0] = 1;
                        dp[0][1] = 1;
                    }
                    continue;
                }
                if (nums[i] == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = dp[i - 1][0];
                } else {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            }


//            Utils.printTable(dp);
            int sub = -1;
            for (int i = 0; i < dp.length; i++) {
                if (nums[i] == 0) {
                    sub = 0;
                    break;
                }
            }

            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                max = Math.max(max, dp[i][1]);
            }
            return max + sub;


        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}



package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-08-01 15:26:12
 * 题目名称: 一个小组的最大实力值
 * 题目类型:
 * 思考:
 */
public class Code2708_maximumStrengthOfAGroup {
    public static void main(String[] args) {
        Solution solution = new Code2708_maximumStrengthOfAGroup().new Solution();

        int[] array = {-7, -4, -4, -1, 5, 5, -3, 4};

        long l = solution.maxStrength(array);
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public long maxStrength(int[] nums) {


            // 0: 正数最大值
            // 1: 负数最大值
            long[][] dp = new long[nums.length][2];
//

            dp[0][0] = nums[0];
            dp[0][1] = nums[0];


            for (int i = 1; i < dp.length; i++) {

                if (nums[i] > 0) {
                    dp[i][0] = max(dp[i - 1][0] * nums[i], dp[i - 1][0], nums[i]);
                    dp[i][1] = min(dp[i - 1][1] * nums[i], dp[i - 1][1], nums[i]);
                } else if (nums[i] < 0) {
                    dp[i][0] = max(dp[i - 1][1] * nums[i], dp[i - 1][0], nums[i]);
                    dp[i][1] = min(dp[i - 1][0] * nums[i], dp[i - 1][1], nums[i]);
                } else {
                    dp[i][0] = Math.max(dp[i - 1][0], nums[i]);
                    dp[i][1] = Math.min(dp[i - 1][1], nums[i]);
                }
            }
//            Utils.printTable(dp);

            return dp[dp.length - 1][0];

        }

        private long max(long a, long b, long c) {
            return Math.max(a, Math.max(b, c));
        }


        private long min(long a, long b, long c) {
            return Math.min(a, Math.min(b, c));
        }

//        public long maxStrength(int[] nums) {
//
//            if (nums.length == 1) {
//                return nums[0];
//            }
//            long sum = 1;
//            long length = 0;
//            long max = Integer.MIN_VALUE;
//            for (int s : nums) {
//                max = Math.max(max, s);
//                if (s == 0) {
//                    continue;
//                }
//                sum *= s;
//                length++;
//            }
//            if (length == 0) {
//                return 0;
//            }
//            if (sum > 0) {
//                return sum;
//            }
//
//            if (length <= 1) {
//                return max;
//            }
//
//            long min = Integer.MIN_VALUE;
//            for (int s : nums) {
//                if (s < 0) {
//                    min = Math.max(min, s);
//                }
//            }
//
//            return sum / min;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-01 15:26:12
 * 题目名称: 一个小组的最大实力值
 * 题目类型:
 * 思考:
 */
public class Code2708_maximumStrengthOfAGroup {
    public static void main(String[] args) {
        Solution solution = new Code2708_maximumStrengthOfAGroup().new Solution();

        int[] array = {0, 0, 0};

        long l = solution.maxStrength(array);
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public long maxStrength(int[] nums) {
            int[][] dp = new int[nums.length][];

            for (int i = 0; i < dp.length; i++) {

                if (nums[i] > 0) {
//                    dp[i][0] = dp[i][]
                }
            }

            return 0;

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

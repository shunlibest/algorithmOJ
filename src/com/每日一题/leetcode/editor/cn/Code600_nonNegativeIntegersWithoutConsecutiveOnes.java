package com.每日一题.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * [每日一题] 2024-08-05 10:25:14
 * 题目名称: 不含连续1的非负整数
 * 题目类型:
 * 思考:
 */
public class Code600_nonNegativeIntegersWithoutConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new Code600_nonNegativeIntegersWithoutConsecutiveOnes().new Solution();


        int integers = solution.findIntegers(1000000000);
        System.out.println(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findIntegers(int n) {
            boolean[] dp = new boolean[n + 1];
            int count = 0;
            dp[0] = true;
            dp[1] = true;
            for (int i = 0; i < dp.length; i++) {
                if (i % 2 == 0) {
                    dp[i] = dp[i / 2];
                } else {
                    dp[i] = (i / 2) % 2 == 0 && dp[i / 2];
                }
                if (dp[i]) {
                    count++;
                }
            }

            return count;
        }

//        public int findIntegers(int n) {
////            boolean[] dp = new boolean[n + 1];
//            Set<Integer> set = new HashSet<>(n / 2);
//
//            int count = 0;
//            set.add(0);
////            dp[0] = true;
////            dp[1] = true;
//            for (int i = 0; i < n + 1; i++) {
//                boolean dp;
//                if (i % 2 == 0) {
//                    dp = set.contains(i / 2);
//                } else {
//                    dp = (i / 2) % 2 == 0 && set.contains(i / 2);
//                }
//                if (dp) {
//                    count++;
//                    set.add(i);
//                }
//            }
//
////            System.out.println(Arrays.toString(Arrays.stream(set.toArray()).toArray()));
//
//            return count;
//        }

        /**
         *
         * 0 000
         * 1 001
         * 2 010
         * 3 011
         * 4 100
         * 5 101
         * 6 110
         * 7 111
         *
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}

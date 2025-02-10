package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-30 10:24:32
 * 题目名称: 所有数对中数位不同之和
 * 题目类型:
 * 思考:
 */


public class Code3153_sumOfDigitDifferencesOfAllPairs {
    public static void main(String[] args) {
        Solution solution = new Code3153_sumOfDigitDifferencesOfAllPairs().new Solution();
        int[] i0 = {10,10,10,10};
        long l = solution.sumDigitDifferences(i0);
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long sumDigitDifferences(int[] nums) {
            int length = String.valueOf(nums[0]).length();
            long max = length * ((long) nums.length * (nums.length - 1) / 2);

            long sameCount = 0;
            for (long i = 0; i < length; i++) {
                long[] num = new long[10];

                for (int numCount : nums) {

                    int n = numCount / ((int) Math.pow(10, i)) % 10;

//                    System.out.println(n);
                    sameCount += num[n];
                    num[n]++;
                }
            }

//            System.out.println(max);
//            System.out.println(sameCount);
            return max - sameCount;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

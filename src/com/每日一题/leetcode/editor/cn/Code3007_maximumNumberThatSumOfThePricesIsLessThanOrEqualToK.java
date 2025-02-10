package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-21 10:27:19
 * 题目名称: 价值和小于等于 K 的最大数字
 * 题目类型:
 * 思考:
 */


public class Code3007_maximumNumberThatSumOfThePricesIsLessThanOrEqualToK {
    public static void main(String[] args) {
        Solution solution = new Code3007_maximumNumberThatSumOfThePricesIsLessThanOrEqualToK().new Solution();
        Object i0 = 9;
        Object i1 = 7;
        long maximumNumber = solution.findMaximumNumber(3278539330613L, 5);
        System.out.println(maximumNumber);

//        int value = solution.getValue(10, 2);
//        System.out.println();
//        System.out.println(value);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long findMaximumNumber(long k, int x) {

            int sum = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                int value = getValue(i, x);
                sum += value;

//                System.out.println("num:" + i + ",price:" + value + ",sum:" + sum);
                if (sum > k) {
                    return i - 1;
                }
            }


            return 0;
        }

        private int getValue(int num, int x) {
            int count = 0;
//            System.out.println("二进制:" + Integer.toString(num, 2));


            for (int i = 0; i < 10; i++) {
//                if ((num >> i) % 2 == 0) {
//                    System.out.print("0");
//                } else {
//                    System.out.print("1");
//
//                }
//               (Integer.toString(num >> (i), 2));
            }
            String s = Integer.toBinaryString(num);
//            System.out.println(s.length());
            for (int i = 1; i < s.length() / x; i++) {
                int one = (num >> (x * i - 1)) % 2;
                if (one == 1) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

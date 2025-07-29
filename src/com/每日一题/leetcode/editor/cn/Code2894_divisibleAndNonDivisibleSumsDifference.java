package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-05-27 10:38:26
 * 题目名称: 分类求和并作差
 * 题目类型:
 * 思考:
 */


public class Code2894_divisibleAndNonDivisibleSumsDifference {
    public static void main(String[] args) {
        Solution solution = new Code2894_divisibleAndNonDivisibleSumsDifference().new Solution();
        Object i0 = 10;
        Object i1 = 5;
        Object i2 = 5;


        int i = solution.differenceOfSums(10, 3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int differenceOfSums(int n, int m) {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (i % m == 0) {
                    result -= i;
                } else {
                    result += i;
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

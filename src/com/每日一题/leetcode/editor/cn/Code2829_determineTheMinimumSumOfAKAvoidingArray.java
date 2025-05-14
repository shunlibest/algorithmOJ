package com.每日一题.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * [每日一题] 2025-03-26 10:48:06
 * 题目名称: k-avoiding 数组的最小总和
 * 题目类型:
 * 思考:
 */


public class Code2829_determineTheMinimumSumOfAKAvoidingArray {
    public static void main(String[] args) {
        Solution solution = new Code2829_determineTheMinimumSumOfAKAvoidingArray().new Solution();
        Object i0 = 5;
        Object i1 = 2;
        int i = solution.minimumSum(5, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSum(int n, int k) {

            Set<Integer> currentSet = new HashSet<>();

            int sum = 0;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                if (currentSet.contains(k - i)) {
                    continue;
                }

                currentSet.add(i);
                sum += i;
//                System.out.println(i);
                if (currentSet.size() >= n) {
                    return sum;
                }

            }

            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

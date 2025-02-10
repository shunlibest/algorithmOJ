package com.每日一题.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * [每日一题] 2024-08-12 13:55:42
 * 题目名称: 求出最长好子序列 I
 * 题目类型:
 * 思考:
 */


public class Code3176_findTheMaximumLengthOfAGoodSubsequenceI {
    public static void main(String[] args) {
        Solution solution = new Code3176_findTheMaximumLengthOfAGoodSubsequenceI().new Solution();
        int[] i0 = {1, 2, 1, 1, 3};
//        Object i1 = {1,2,3,4,5,1};
        int i = solution.maximumLength(i0, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums, int k) {
            int[][]   dp = new int[nums.length][k];

            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < dp.length; i++) {

//                dp[i][k] =
//
//                for (int value : set) {
//
//                }
//

            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

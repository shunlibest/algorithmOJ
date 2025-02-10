package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2024-08-08 16:36:45
 * 题目名称: 最长定差子序列
 * 题目类型:
 * 思考:
 */


public class Code1218_longestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new Code1218_longestArithmeticSubsequenceOfGivenDifference().new Solution();
//        int[] i0 = {1, 2, 3, 4};
//        int[] i1 = {1,3,5,7};
        int[] i2 = {3, 4, -3, -2, -4};
        int i = solution.longestSubsequence(i2, -5);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {

            int[] dp = new int[arr.length];
            Map<Integer, Integer> map = new HashMap<>(arr.length);
            int max = 1;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;

                int num = map.getOrDefault(arr[i] - difference, 0);
                dp[i] = Math.max(dp[i], num + 1);
                max = Math.max(max, dp[i]);
                map.put(arr[i], dp[i]);
            }

//            Utils.printTable(dp);

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

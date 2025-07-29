package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * [每日一题] 2025-06-30 14:54:11
 * 题目名称: 最长和谐子序列
 * 题目类型:
 * 思考:
 */


public class Code594_longestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new Code594_longestHarmoniousSubsequence().new Solution();
        int[] i0 = {1, 3, 2, 2, 5, 2, 3, 7};
//        int[] i0 = {1, 3, 2,};
        int[] i1 = {1, 1, 1, 1};
        int lhs = solution.findLHS(i1);
        System.out.println(lhs);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int num : nums) {
                int current = countMap.getOrDefault(num, 0);
                countMap.put(num, current + 1);
            }

            int max = 0;

            for (Map.Entry<Integer, Integer> item : countMap.entrySet()) {
                max = Math.max(max, item.getValue() + countMap.getOrDefault(item.getKey() + 1, Integer.MIN_VALUE));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

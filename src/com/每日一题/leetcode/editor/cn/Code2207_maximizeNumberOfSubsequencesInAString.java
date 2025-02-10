package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-09-24 09:52:16
 * 题目名称: 字符串中最多数目的子序列
 * 题目类型:
 * 思考:
 */


public class Code2207_maximizeNumberOfSubsequencesInAString {
    public static void main(String[] args) {
        Solution solution = new Code2207_maximizeNumberOfSubsequencesInAString().new Solution();
        Object i0 = "abdcdbc";
        Object i1 = "aabb";
        long l = solution.maximumSubsequenceCount("abdcdbc", "ac");
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSubsequenceCount(String text, String pattern) {

            List<Integer> operateList = new ArrayList<>();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == pattern.charAt(0)) {
                    operateList.add(0);
                } else if (text.charAt(i) == pattern.charAt(1)) {
                    operateList.add(1);
                }
            }
            int[] array = new int[text.length()];
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 14:21:00
 * 题目名称: 找到最大开销的子字符串
 * 题目类型:
 * 思考:
 */
public class Code2606_findTheSubstringWithMaximumCost {
    public static void main(String[] args) {
        Solution solution = new Code2606_findTheSubstringWithMaximumCost().new Solution();
        int i = solution.maximumCostSubstring("zox", "zoxr", new int[]{2, -5, -4, -5});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCostSubstring(String s, String chars, int[] vals) {
            int[] maxValue = new int[s.length()];
            char[] sChar = s.toCharArray();
            char[] valueChar = chars.toCharArray();

            int[] valueList = new int[26];
            for (int i = 0; i < valueList.length; i++) {
                valueList[i] = i + 1;
            }
            for (int i = 0; i < valueChar.length; i++) {
                valueList[valueChar[i] - 'a'] = vals[i];
            }


            maxValue[0] = valueList[sChar[0] - 'a'];
            int maxResult = Math.max(maxValue[0], 0);
            for (int i = 1; i < maxValue.length; i++) {
                maxValue[i] = Math.max(maxValue[i - 1], 0) + valueList[sChar[i] - 'a'];
                maxResult = Math.max(maxResult, maxValue[i]);
            }

            return maxResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

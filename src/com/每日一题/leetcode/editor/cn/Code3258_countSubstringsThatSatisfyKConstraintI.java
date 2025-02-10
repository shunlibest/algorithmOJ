package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-11-12 10:08:04
 * 题目名称: 统计满足 K 约束的子字符串数量 I
 * 题目类型:
 * 思考:
 */


public class Code3258_countSubstringsThatSatisfyKConstraintI {
    public static void main(String[] args) {
        Solution solution = new Code3258_countSubstringsThatSatisfyKConstraintI().new Solution();
        Object i0 = "10101";
        Object i1 = "1010101";
        Object i2 = "11111";
        int i = solution.countKConstraintSubstrings("11111", 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKConstraintSubstrings(String s, int k) {

            int left = 0;
            int right = 0;

            int zeroCount = 0;
            int oneCount = 0;

            int res = 0;
            while (left < s.length() && right < s.length()) {
                if (zeroCount > k || oneCount > k) {
                    if (s.charAt(left) == '0') {
                        zeroCount--;
                    } else {
                        oneCount--;
                    }
                    res += right - left;
                    left++;
                } else {
                    if (s.charAt(right) == '0') {
                        zeroCount--;
                    } else {
                        oneCount--;
                    }
                    right++;

                }
            }

            while (left < s.length()) {
                if (zeroCount < k && oneCount < k) {
                    res += right - left;
                }else {
                    if (s.charAt(left) == '0') {
                        zeroCount--;
                    } else {
                        oneCount--;
                    }
                }
                left++;
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

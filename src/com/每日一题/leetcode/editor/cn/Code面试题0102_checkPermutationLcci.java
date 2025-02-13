package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-02-12 17:21:10
 * 题目名称: 判定是否互为字符重排
 * 题目类型:
 * 思考:
 */


public class Code面试题0102_checkPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new Code面试题0102_checkPermutationLcci().new Solution();
        Object i0 = "abc";
        Object i1 = "abc";
        boolean b = solution.CheckPermutation("uhwpykcr", "wcpcytuk");

        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            char[] char1 = s1.toCharArray();
            char[] char2 = s2.toCharArray();


            if (char1.length != char2.length){
                return false;
            }

            int[] charCount = new int[26];
            for (char c : char1) {
                charCount[c - 'a'] ++;
            }

            for (char c : char2) {
                charCount[c - 'a'] --;
            }


            for (int i : charCount) {
                if (i!=0){
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

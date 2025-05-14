package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-03-24 10:05:18
 * 题目名称: 统计是给定字符串前缀的字符串数目
 * 题目类型:
 * 思考:
 */
 

public class Code2255_countPrefixesOfAGivenString{
    public static void main(String[] args) {
        Solution solution = new Code2255_countPrefixesOfAGivenString().new Solution();
        String[] i0 = {"a","b","c","ab","bc"};
//        Object i1 = {"a","a"};
        int abc = solution.countPrefixes(i0, "abc");
        System.out.println(abc);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String word : words) {
            if (s.startsWith(word)){
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-07-01 10:21:27
 * 题目名称: 找到初始输入字符串 I
 * 题目类型:
 * 思考:
 */
 

public class Code3330_findTheOriginalTypedStringI{
    public static void main(String[] args) {
        Solution solution = new Code3330_findTheOriginalTypedStringI().new Solution();
        Object i0 = "abbcccc";
        Object i1 = "aaaa";
        int i = solution.possibleStringCount("abbcccc");
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int possibleStringCount(String word) {
        char[] charArray = word.toCharArray();

        int count = 0;
        int result = 1;
        char beforeChar = '\0';
        for (char c : charArray) {
            if (c == beforeChar){
                count++;
            }else {
                result += count;
                count = 0;
            }
            beforeChar = c;
        }
        result += count;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

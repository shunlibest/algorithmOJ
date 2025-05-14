package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-03-31 11:44:33
 * 题目名称: 字母在字符串中的百分比
 * 题目类型:
 * 思考:
 */
 

public class Code2278_percentageOfLetterInString{
    public static void main(String[] args) {
        Solution solution = new Code2278_percentageOfLetterInString().new Solution();
        Object i0 = "foobar";
        Object i1 = "jjjj";
        int i = solution.percentageLetter("foobar", 'o');
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int percentageLetter(String s, char letter) {

        char[] chars = s.toCharArray();

        int count = 0;
        for (char aChar : chars) {
            if (aChar == letter){
                count++;
            }
        }

        return count * 100 / chars.length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

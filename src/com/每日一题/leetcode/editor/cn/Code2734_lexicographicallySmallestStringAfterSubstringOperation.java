package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-27 10:11:55
 * 题目名称: 执行子串操作后的字典序最小字符串
 * 题目类型:
 * 思考:
 */
public class Code2734_lexicographicallySmallestStringAfterSubstringOperation {
    public static void main(String[] args) {
        Solution solution = new Code2734_lexicographicallySmallestStringAfterSubstringOperation().new Solution();
        String res = solution.smallestString("aa");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestString(String s) {

            char[] chars = s.toCharArray();

            boolean started = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 'a') {
                    chars[i] -= 1;
                    started = true;
                }else if (started){
                    break;
                }
            }
            if (!started){
                chars[chars.length-1] = 'z';
            }

            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

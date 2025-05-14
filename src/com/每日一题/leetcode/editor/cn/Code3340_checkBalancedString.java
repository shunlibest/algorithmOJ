package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-03-14 10:41:17
 * 题目名称: 检查平衡字符串
 * 题目类型:
 * 思考:
 */
 

public class Code3340_checkBalancedString{
    public static void main(String[] args) {
        Solution solution = new Code3340_checkBalancedString().new Solution();
        Object i0 = "1234";
        boolean balanced = solution.isBalanced("24123");
        System.out.println(balanced);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBalanced(String num) {
        char[] chars = num.toCharArray();

        boolean odd = true;
        int sum = 0;
        for (char aChar : chars) {
            if (odd){
                sum += (aChar - '0');
            }else {
                sum -= (aChar - '0');
            }
            odd = !odd;
        }

        return sum ==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-10-17 11:13:08
 * 题目名称: 只出现一次的数字
 * 题目类型:
 * 思考:
 */


public class Code136_singleNumber {
    public static void main(String[] args) {
        Solution solution = new Code136_singleNumber().new Solution();
        int[] i0 = {4,1,2,1,2};
//        Object i1 = {1};
        int i = solution.singleNumber(i0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

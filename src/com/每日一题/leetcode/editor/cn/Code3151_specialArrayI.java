package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-13 11:02:05
 * 题目名称: 特殊数组 I
 * 题目类型:
 * 思考:
 */


public class Code3151_specialArrayI {
    public static void main(String[] args) {
        Solution solution = new Code3151_specialArrayI().new Solution();
//        Object i0 = {1};
        int[] i1 = {4,};
        boolean arraySpecial = solution.isArraySpecial(i1);
        System.out.println(arraySpecial);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isArraySpecial(int[] nums) {

            boolean lastIsEvent = nums[0] % 2 != 0;
            for (int num : nums) {
                boolean isEvent = num % 2 == 0;
                if (lastIsEvent == isEvent) {
                    return false;
                }
                lastIsEvent = !lastIsEvent;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

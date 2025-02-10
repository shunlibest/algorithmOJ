package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-11-26 09:59:32
 * 题目名称: 交替组 I
 * 题目类型:
 * 思考:
 */


public class Code3206_alternatingGroupsI {
    public static void main(String[] args) {
        Solution solution = new Code3206_alternatingGroupsI().new Solution();
        int[] i0 = {1, 1, 1};
        int i = solution.numberOfAlternatingGroups(i0);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfAlternatingGroups(int[] colors) {
            int count = 0;
            for (int i = 0; i < colors.length; i++) {

                if (colors[i] != colors[(i - 1 + colors.length) % colors.length] &&
                        colors[i] != colors[(i + 1) % colors.length]) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

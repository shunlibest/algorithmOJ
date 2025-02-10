package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-29 09:59:48
 * 题目名称: 判断矩阵是否满足条件
 * 题目类型:
 * 思考:
 */


public class Code3142_checkIfGridSatisfiesConditions {
    public static void main(String[] args) {
        Solution solution = new Code3142_checkIfGridSatisfiesConditions().new Solution();
        int[][] i0 = {{1, 0, 2}, {1, 0, 2}};
//        Object i1 = {{1}, {2}, {3}};
        boolean b = solution.satisfiesConditions(i0);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean satisfiesConditions(int[][] grid) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {

                    if (i > 0 && grid[i][j] != grid[i - 1][j]) {
                        return false;
                    }


                    if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                        return false;
                    }


                }

            }

            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

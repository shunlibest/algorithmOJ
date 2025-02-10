package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-09-02 14:39:36
 * 题目名称: 旋转图像
 * 题目类型:
 * 思考:
 */


public class Code48_rotateImage {
    public static void main(String[] args) {
        Solution solution = new Code48_rotateImage().new Solution();
        int[][] i0 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(i0);

        Utils.printTable(i0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {

            for (int round = 0; round < matrix.length / 2; round++) {

            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-11-18 14:52:38
 * 题目名称: 图片平滑器
 * 题目类型:
 * 思考:
 */


public class Code661_imageSmoother {
    public static void main(String[] args) {
        Solution solution = new Code661_imageSmoother().new Solution();
        int[][] i0 = Utils.convertStringTo2DArray("[[100,200,100],[200,50,200],[100,200,100]]");
        int[][] ints = solution.imageSmoother(i0);
        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            int[][] res = new int[img.length][img[0].length];

            for (int i = 0; i < img.length; i++) {
                for (int j = 0; j < img[0].length; j++) {
                    res[i][j] = getAvage(img, i, j);
                }
            }
            return res;
        }

        private int getAvage(int[][] img, int x, int y) {
            int sum = 0;
            int count = 0;
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {

                    Integer value = getValue(img, i, j);
                    if (value != null) {
                        sum += value;
                        count++;
                    }
                }
            }
            return sum / count;
        }

        private Integer getValue(int[][] matrix, int x, int y) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                return null;
            }
            return matrix[x][y];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

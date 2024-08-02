package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * [每日一题] 2024-07-22 11:02:23
 * 题目名称: 堆叠长方体的最大高度
 * 题目类型:
 * 思考:
 */
public class Code1691_maximumHeightByStackingCuboids {
    public static void main(String[] args) {
        Solution solution = new Code1691_maximumHeightByStackingCuboids().new Solution();

        int i = solution.maxHeight(Utils.convertStringTo2DArray("[[50,45,20],[95,37,53],[45,23,12]]"));

        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeight(int[][] cuboids) {


            Arrays.sort(cuboids, (o1, o2) -> {
                boolean small = true;
                for (int i = 0; i < 3; i++) {
                    small = small && (o1[0] < o2[0]);
                }
                return small ? 1 : -1;
            });

            Utils.printTable(cuboids);

            int[] dp = new int[cuboids.length];


            for (int i = 0; i < dp.length; i++) {
                dp[i] = max(cuboids[i]);
                for (int j = 0; j < i; j++) {
                    if (compare(cuboids[i], cuboids[j])) {
                        dp[i] = Math.max(dp[i], dp[j] + max(cuboids[i]));
                    }
                }
            }

            int max = 0;
            for (int value : dp) {
                max = Math.max(max, value);
            }
            return max;
        }

        private boolean compare(int[] a, int[] b) {
            boolean big = true;
            for (int i = 0; i < 3; i++) {
                big = big && (a[0] >= b[0]);
            }
            return big;
        }

        private int max(int[] a) {
            int max = a[0];
            for (int i = 0; i < 3; i++) {
                max = Math.max(max, a[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

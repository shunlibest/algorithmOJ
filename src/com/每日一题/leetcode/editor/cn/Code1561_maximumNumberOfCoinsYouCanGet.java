package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2025-01-22 10:45:05
 * 题目名称: 你可以获得的最大硬币数目
 * 题目类型:
 * 思考:
 */


public class Code1561_maximumNumberOfCoinsYouCanGet {
    public static void main(String[] args) {
        Solution solution = new Code1561_maximumNumberOfCoinsYouCanGet().new Solution();
        int[] i0 = {2, 4, 1, 2, 7, 8};
        int[] i1 = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        int i = solution.maxCoins(i1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);

            int round = piles.length / 3;

            int result = 0;
            for (int i = round; i < piles.length; i += 2) {
                result += piles[i];
            }

            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

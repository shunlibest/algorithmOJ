package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-08-01 09:54:22
 * 题目名称: 心算挑战
 * 题目类型:
 * 思考:
 */
public class CodeLCP40_uOAnQW {
    public static void main(String[] args) {
        Solution solution = new CodeLCP40_uOAnQW().new Solution();
        int[] array = {1, 4, 7};
        int i = solution.maxmiumScore(array, 1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxmiumScore(int[] cards, int cnt) {
            Arrays.sort(cards);

            int remove = cards.length - cnt;
            int sum = 0;
            int minOdd = -1;
            int minEven = -1;
            for (int i = cards.length - 1; i >= remove; i--) {
                sum += cards[i];
                if (cards[i] % 2 == 0) {
                    minEven = cards[i];
                } else {
                    minOdd = cards[i];
                }
            }
            if (sum % 2 == 0) {
                return sum;
            }
            int maxOdd = -1;
            int maxEven = -1;
            for (int i = 0; i < remove; i++) {
                if (cards[i] % 2 == 0) {
                    maxEven = cards[i];
                } else {
                    maxOdd = cards[i];
                }
            }
//            System.out.println("maxEven:" + maxEven);
//            System.out.println("maxOdd:" + maxOdd);

            int subValue = Integer.MAX_VALUE;
            if (minEven != -1 && maxOdd != -1) {
                subValue = minEven - maxOdd;
            }
            if (maxEven != -1 && minOdd != -1) {
                subValue = Math.min(subValue, minOdd - maxEven);
            }

            if (subValue == Integer.MAX_VALUE) {
                return 0;
            }

//            System.out.println(subValue);

            return sum - subValue;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

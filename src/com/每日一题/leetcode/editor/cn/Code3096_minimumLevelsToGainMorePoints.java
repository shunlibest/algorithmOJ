package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-19 10:26:47
 * 题目名称: 得到更多分数的最少关卡数目
 * 题目类型:
 * 思考:
 */
public class Code3096_minimumLevelsToGainMorePoints {
    public static void main(String[] args) {
        Solution solution = new Code3096_minimumLevelsToGainMorePoints().new Solution();

        int[] array = {1, 1, 1, 1, 1};
        int i = solution.minimumLevels(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLevels(int[] possible) {
            int[] preSum = new int[possible.length];
            int[] subSum = new int[possible.length];

            for (int i = 0; i < possible.length; i++) {
                int score = possible[i] > 0 ? 1 : -1;
                preSum[i] = getValue(preSum, i - 1) + score;
            }


            for (int i = subSum.length - 1; i >= 0; i--) {
                int score = possible[i] > 0 ? 1 : -1;
                subSum[i] = getValue(subSum, i + 1) + score;
            }

            for (int i = 0; i < preSum.length - 1; i++) {
                if (preSum[i] > subSum[i + 1]) {
                    return i + 1;
                }
            }

            return -1;
        }

        private int getValue(int[] array, int index) {
            if (index < 0 || index >= array.length) {
                return 0;
            }
            return array[index];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

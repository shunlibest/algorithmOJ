package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-02-13 10:53:56
 * 题目名称: 盒子中小球的最大数量
 * 题目类型:
 * 思考:
 */


public class Code1742_maximumNumberOfBallsInABox {
    public static void main(String[] args) {
        Solution solution = new Code1742_maximumNumberOfBallsInABox().new Solution();
        Object i0 = 1;
        Object i1 = 5;
        Object i2 = 19;
        int i = solution.countBalls(6745, 28696);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {

            int[] value = new int[50];

            int max = 0;

            for (int i = lowLimit; i <= highLimit; i++) {


                int digitsSum = getDigitsSum(i);

//                System.out.println(digitsSum);

                value[digitsSum]++;
                max = Math.max(max, value[digitsSum]);


            }

            return max;
        }

        private int getDigitsSum(int i) {

            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }

            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

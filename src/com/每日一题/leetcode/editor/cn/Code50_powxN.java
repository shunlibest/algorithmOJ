package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-09-02 14:58:45
 * 题目名称: Pow(x, n)
 * 题目类型:
 * 思考:
 */


public class Code50_powxN {
    public static void main(String[] args) {
        Solution solution = new Code50_powxN().new Solution();
        Object i0 = 2.00000;
        Object i1 = 2.10000;
        Object i2 = 2.00000;
        double v = solution.myPow(2.0, -2);

        System.out.println(v);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n) {
            if (n > 0) {
                return _myPow(x, n);
            } else {
                return 1 / _myPow(x, -n);

            }


        }

        public double _myPow(double x, int n) {

            if (n == 0) {
                return 1;
            }

            if (n == 1) {
                return x;
            }

            if (n == 2) {
                return x * x;
            }

            if (n % 2 == 0) {
                return _myPow(_myPow(x, n / 2), 2);

            } else {
                return _myPow(_myPow(x, n / 2), 2) * x;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

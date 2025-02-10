package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-09-03 16:20:10
 * 题目名称: 丑数
 * 题目类型:
 * 思考:
 */


public class Code263_uglyNumber {
    public static void main(String[] args) {
        Solution solution = new Code263_uglyNumber().new Solution();
        Object i0 = 6;
        Object i1 = 14;
        boolean ugly = solution.isUgly(1);
        System.out.println(ugly);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) {
                return false;
            }
            int[] mods = {2, 3, 5};
            while (n != 1) {
                boolean changed = false;
                for (int mod : mods) {
                    if (n % mod == 0) {
                        n = n / mod;
                        changed = true;
                    }
                }
                if (!changed) {
                    break;
                }
            }

//            System.out.println(n);


            return n == 1;
        }

        private boolean isPrime(int n) {
            if (n == 1) {
                return true;
            }

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

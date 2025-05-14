package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2025-02-20 10:27:06
 * 题目名称: 奇偶位数
 * 题目类型:
 * 思考:
 */


public class Code2595_numberOfEvenAndOddBits {
    public static void main(String[] args) {
        Solution solution = new Code2595_numberOfEvenAndOddBits().new Solution();
        int i0 = 50;
        int[] ints = solution.evenOddBit(50);
        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] evenOddBit(int n) {
            int evenCount = 0;
            int oddCount = 0;

            boolean even = true;
            while (n > 0) {
                if (n % 2 == 1) {
                    if (even) {
                        evenCount++;
                    } else {
                        oddCount++;
                    }
                }

                even = !even;
                n = n / 2;
            }

            return new int[]{evenCount, oddCount};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [每日一题] 2024-06-27 15:07:52
 * 题目名称: K 次串联后最大子数组之和
 * 题目类型:
 * 思考:
 */
public class Code1191_kConcatenationMaximumSum {
    public static void main(String[] args) {
        Solution solution = new Code1191_kConcatenationMaximumSum().new Solution();
        int[] array = {10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,};
        int i = solution.kConcatenationMaxSum(array, 100000);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = 1_000_000_007;

        public int kConcatenationMaxSum(int[] arr, int k) {

            long sum = 0;
            for (int a : arr) {
                sum = (sum + a) % MOD;
            }

            long[] maxList = new long[arr.length * 2 + 1];
            maxList[0] = arr[0];
            long max = Math.max(arr[0], 0);
            for (int i = 1; i < arr.length * 2 + 1; i++) {
                if (i < arr.length) {
                    maxList[i] = Math.max(maxList[i - 1], 0) + arr[i];
                } else if (i == arr.length) {
                    if (k == 1) {
                        return (int) (Math.max(max, maxList[i]) % MOD);
                    }
                    maxList[i] = Math.max(maxList[i - 1], 0) + Math.max(sum, 0) * (k - 2);
                } else {
                    maxList[i] = Math.max(maxList[i - 1], 0) + arr[i - arr.length - 1];
                }
//                maxList[i] = maxList[i] % MOD;
                max = Math.max(max, maxList[i]) ;
            }

//            System.out.println(Arrays.toString(maxList));

//            long x = 10000000000L % MOD;

            return (int) (max % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

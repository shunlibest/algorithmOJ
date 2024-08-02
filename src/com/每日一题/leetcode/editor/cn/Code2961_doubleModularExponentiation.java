package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2024-07-30 11:02:29
 * 题目名称: 双模幂运算
 * 题目类型:
 * 思考:
 */
public class Code2961_doubleModularExponentiation {
    public static void main(String[] args) {
        Solution solution = new Code2961_doubleModularExponentiation().new Solution();

        List<Integer> goodIndices = solution.getGoodIndices(Utils.convertStringTo2DArray("[[3,2,2,3]]"), 0);

        System.out.println(Arrays.toString(goodIndices.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getGoodIndices(int[][] variables, int target) {

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < variables.length; i++) {
                if (isGood(variables[i], target)) {
                    res.add(i);
                }
            }
            return res;
        }

        private boolean isGood(int[] input, int target) {
            return isGood(input[0], input[1], input[2], input[3], target);
        }

        private boolean isGood(int a, int b, int c, int m, int target) {
            a = a % 10;
//            int v = (int) Math.pow(a, b * c) % 10;

            int v = (int) Math.pow((int) Math.pow(a, b) % 10, c);
            return v % m == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

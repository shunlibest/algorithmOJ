package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2025-05-12 16:15:51
 * 题目名称: 找出 3 位偶数
 * 题目类型:
 * 思考:
 */


public class Code2094_finding3DigitEvenNumbers {
    public static void main(String[] args) {
        Solution solution = new Code2094_finding3DigitEvenNumbers().new Solution();
        int[] i0 = {2,2,8,8,2};
//        Object i1 = {3,7,5};
        int[] evenNumbers = solution.findEvenNumbers(i0);
        Utils.printTable(evenNumbers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findEvenNumbers(int[] digits) {
            Arrays.sort(digits);

            boolean[] visited = new boolean[digits.length];
            List<Integer> currentList = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            result(digits, visited, currentList, 0, result);

            int[] out = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                out[i] = result.get(i);
            }

            return out;
        }


        private void result(int[] digits, boolean[] visited, List<Integer> currentList, int currentListSize, List<Integer> res) {

            if (currentListSize == 3) {

                StringBuilder sb = new StringBuilder();
                for (Integer i : currentList) {
                    sb.append(i);
                }

                int value = Integer.parseInt(sb.toString());

                if (value % 2 == 0) {
                    res.add(value);
                }


                return;
            }

            for (int i = 0; i < digits.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (currentListSize == 0 && digits[i] == 0) {
                    continue;
                }

                if (i > 0 && digits[i] == digits[i - 1] && !visited[i-1]) {
                    continue;
                }


                visited[i] = true;
                currentList.add(digits[i]);

                result(digits, visited, currentList, currentListSize + 1, res);
                visited[i] = false;
                currentList.remove(currentList.size() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

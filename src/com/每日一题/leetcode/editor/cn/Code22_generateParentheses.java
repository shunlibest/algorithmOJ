package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [每日一题] 2024-08-30 14:39:15
 * 题目名称: 括号生成
 * 题目类型:
 * 思考:
 */


public class Code22_generateParentheses {
    public static void main(String[] args) {
        Solution solution = new Code22_generateParentheses().new Solution();
        Object i0 = 3;
        List<String> strings = solution.generateParenthesis(3);

        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            Set<String> results = new HashSet<>();
            reverse(results, "()", n - 1);

            return new ArrayList<>(results);
        }

        private void reverse(Set<String> results, String current, int step) {
            if (step == 0) {
                results.add(current);
                return;
            }

            for (int i = 0; i < current.length() + 1; i++) {
                String s = current.substring(0, i) + "()" + current.substring(i);
//                System.out.println(s);

                reverse(results, s, step - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

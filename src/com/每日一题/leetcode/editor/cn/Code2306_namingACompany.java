package com.每日一题.leetcode.editor.cn;

import java.util.*;

/**
 * [每日一题] 2024-09-25 09:59:06
 * 题目名称: 公司命名
 * 题目类型:
 * 思考:
 */


public class Code2306_namingACompany {
    public static void main(String[] args) {
        Solution solution = new Code2306_namingACompany().new Solution();
        String[] i0 = {"coffee", "donuts", "time", "toffee"};
        long l = solution.distinctNames(i0);

        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long distinctNames(String[] ideas) {

            Set<String> set = new HashSet<>(Arrays.asList(ideas));

            long result = 0;
            for (int i = 0; i < ideas.length; i++) {
                for (int j = i + 1; j < ideas.length; j++) {

                    String swap1 = ideas[i].charAt(0) + ideas[j].substring(1);
                    String swap2 = ideas[j].charAt(0) + ideas[i].substring(1);

//                    System.out.println(swap1 + "," + swap2);

                    if (!set.contains(swap1) && !set.contains(swap2)) {
                        result++;
                    }
                }
            }
            return result * 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

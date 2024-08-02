package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-18 16:39:05
 * 题目名称: 给小朋友们分糖果 I
 * 题目类型:
 * 思考:
 */
public class Code2928_distributeCandiesAmongChildrenI {
    public static void main(String[] args) {
        Solution solution = new Code2928_distributeCandiesAmongChildrenI().new Solution();
        int i = solution.distributeCandies(5, 2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCandies(int n, int limit) {
            int res = 0;
            for (int i = 0; i <= limit; i++) {
                for (int j = i; j <= i + limit && j <= n; j++) {
                    if (n - j <= limit) {
                        res++;
//                        System.out.println(i + ", " + (j - i) + ", " + (n - j));
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

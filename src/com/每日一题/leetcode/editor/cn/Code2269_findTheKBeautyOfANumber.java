package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-03-10 10:08:33
 * 题目名称: 找到一个数字的 K 美丽值
 * 题目类型:
 * 思考:
 */


public class Code2269_findTheKBeautyOfANumber {
    public static void main(String[] args) {
        Solution solution = new Code2269_findTheKBeautyOfANumber().new Solution();
        Object i0 = 240;
        Object i1 = 430043;
        int i = solution.divisorSubstrings(30003, 3);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divisorSubstrings(int num, int k) {

            String numString = String.valueOf(num);
            int count =0 ;
            for (int i = 0; i < numString.length() - k + 1; i++) {
                int value = Integer.parseInt(numString.substring(i, i + k));
                if (value != 0  && num % value ==0){
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-03 10:03:39
 * 题目名称: 哈沙德数
 * 题目类型:
 * 思考:
 */
public class Code3099_harshadNumber {
    public static void main(String[] args) {
        Solution solution = new Code3099_harshadNumber().new Solution();
        int i = solution.sumOfTheDigitsOfHarshadNumber(1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfTheDigitsOfHarshadNumber(int x) {

            int current = x;
            int sum = 0;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }

            if (x % sum ==0){
                return sum;
            }else {
                return -1;
            }

//            System.out.println(sum);

//            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

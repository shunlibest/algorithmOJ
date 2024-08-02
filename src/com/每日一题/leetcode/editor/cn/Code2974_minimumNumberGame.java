package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-07-12 16:26:14
 * 题目名称: 最小数字游戏
 * 题目类型:
 * 思考:
 */
public class Code2974_minimumNumberGame {
    public static void main(String[] args) {
        Solution solution = new Code2974_minimumNumberGame().new Solution();
        int[] array = {5,4,2,3};
        int[] ints = solution.numberGame(array);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberGame(int[] nums) {

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i+=2) {
               int temp=  nums[i] ;
                nums[i] = nums[i+1];
                nums[i+1] =temp;
            }

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

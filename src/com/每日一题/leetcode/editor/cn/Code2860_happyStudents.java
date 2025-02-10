package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [每日一题] 2024-09-04 09:52:27
 * 题目名称: 让所有学生保持开心的分组方法数
 * 题目类型:
 * 思考:
 */


public class Code2860_happyStudents {
    public static void main(String[] args) {
        Solution solution = new Code2860_happyStudents().new Solution();
        int[] a = new int[]{6, 0, 3, 3, 6, 7, 2, 7};
        List<Integer> i0 = Arrays.stream(a).boxed().collect(Collectors.toList());
        int i = solution.countWays(i0);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countWays(List<Integer> nums) {

            Collections.sort(nums);
            int sum = 0;
            if (nums.get(nums.size() - 1) < nums.size()) {
                sum++;
            }

            if (nums.get(0) > 0){
                sum++;
            }


            for (int i = 0; i < nums.size() - 1; i++) {
                if (i + 1 > nums.get(i) && i + 1 < nums.get(i + 1)) {
                    sum++;
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

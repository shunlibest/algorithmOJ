package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2025-02-05 10:18:28
 * 题目名称: 子集 II
 * 题目类型:
 * 思考:
 */


public class Code90_subsetsIi {
    public static void main(String[] args) {
        Solution solution = new Code90_subsetsIi().new Solution();
        int[] i0 = {1, 2, 2};
        List<List<Integer>> lists = solution.subsetsWithDup(i0);
        Utils.printTable(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {

            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> currentList = new ArrayList<>();
            subsets(nums, result, currentList, 0);

            return result;
        }

        private void subsets(int[] nums, List<List<Integer>> result, List<Integer> currentList, int start) {
            result.add(new ArrayList<>(currentList));

            Integer lastNum = null;
            for (int i = start; i < nums.length; i++) {
                if (lastNum != null && nums[i] == lastNum) {
                    continue;
                }
                lastNum = nums[i];
                currentList.add(nums[i]);
                subsets(nums, result, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2024-09-02 14:10:57
 * 题目名称: 全排列 II
 * 题目类型:
 * 思考:
 */


public class Code47_permutationsIi {
    public static void main(String[] args) {
        Solution solution = new Code47_permutationsIi().new Solution();
        int[] i0 = {1, 1, 2};
        List<List<Integer>> lists = solution.permuteUnique(i0);
        Utils.printTable(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            List<Integer> current = new ArrayList<>();
            backtrack(result, nums, visited, current);

            return result;
        }


        public void backtrack(List<List<Integer>> result, int[] nums, boolean[] visited, List<Integer> current) {
            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }
            Integer before = null;
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (before != null && nums[i] == before){
                    continue;
                }
                before = nums[i];

                visited[i] = true;
                current.add(nums[i]);
                backtrack(result, nums, visited, current);
                current.remove(current.size() - 1);

                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

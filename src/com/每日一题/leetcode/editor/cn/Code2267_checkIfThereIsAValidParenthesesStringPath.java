package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * [每日一题] 2024-07-01 17:41:32
 * 题目名称: 检查是否有合法括号字符串路径
 * 题目类型:
 * 思考:
 */
public class Code2267_checkIfThereIsAValidParenthesesStringPath {
    public static void main(String[] args) {
        Solution solution = new Code2267_checkIfThereIsAValidParenthesesStringPath().new Solution();

        char[][] array = new char[][]{{'(', '(', '('}, {')', '(', ')'}, {'(', '(', ')'}, {'(', '(', ')'}};

        boolean b = solution.hasValidPath(array);
        System.out.println(b);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasValidPath(char[][] grid) {
            Set<Integer>[][] set = new Set[grid.length][grid[0].length];

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    set[i][j] = new HashSet<>();
                    int currentValue = charToNum(grid[i][j]);

                    if (i == 0 && j == 0) {
                        if (currentValue < 0) {
                            return false;
                        }
                        set[i][j].add(currentValue);
                    }

                    if (i > 0) {
                        for (int num : set[i - 1][j]) {
                            int value = num + currentValue;
                            if (value >= 0) {
                                set[i][j].add(value);
                            }
                        }
                    }

                    if (j > 0) {
                        for (int num : set[i][j - 1]) {
                            int value = num + currentValue;
                            if (value >= 0) {
                                set[i][j].add(value);
                            }
                        }
                    }

                }
            }

            return set[grid.length - 1][grid[0].length - 1].contains(0);
        }

        private int charToNum(char c) {
            if (c == '(') {
                return 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



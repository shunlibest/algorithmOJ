package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2024-07-01 14:32:24
 * 题目名称: 最大得分的路径数目
 * 题目类型:
 * 思考:
 */
public class Code1301_numberOfPathsWithMaxScore {
    public static void main(String[] args) {
        Solution solution = new Code1301_numberOfPathsWithMaxScore().new Solution();
        String[] array = {"E11", "XXX", "11S"};

        int[] res = solution.pathsWithMaxScore(Arrays.asList(array));

        System.out.println(Arrays.toString(res));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = 1_000_000_007;

        public int[] pathsWithMaxScore(List<String> board) {
            long[][] maxValueDp = new long[board.size()][board.get(0).length()];
            long[][] countDp = new long[board.size()][board.get(0).length()];


            for (int i = maxValueDp.length - 1; i >= 0; i--) {
                for (int j = maxValueDp[0].length - 1; j >= 0; j--) {
                    char currentChar = board.get(i).charAt(j);
                    int currentNum = 0;
                    if (currentChar == 'S') {
                        maxValueDp[i][j] = 0;
                        countDp[i][j] = 1;
                        continue;
                    } else if (currentChar == 'X') {
                        maxValueDp[i][j] = Integer.MIN_VALUE;
                        countDp[i][j] = 0;
                        continue;
                    } else {
                        if (currentChar != 'E') {
                            currentNum = currentChar - '0';
                        }
                    }


                    long left = getValue(maxValueDp, i, j + 1);
                    long top = getValue(maxValueDp, i + 1, j);
                    long leftTop = getValue(maxValueDp, i + 1, j + 1);
                    long max = max(left, top, leftTop);
                    if (max == Integer.MIN_VALUE) {
                        maxValueDp[i][j] = Integer.MIN_VALUE;
                        countDp[i][j] = 0;
                        continue;
                    }

                    maxValueDp[i][j] = max + currentNum;

                    if (max == left) {
                        countDp[i][j] += getValue(countDp, i, j + 1);
                    }
                    if (max == top) {
                        countDp[i][j] += getValue(countDp, i + 1, j);
                    }

                    if (max == leftTop) {
                        countDp[i][j] += getValue(countDp, i + 1, j + 1);
                    }
                    countDp[i][j] %= MOD;
                }
            }

//            Utils.print2DArray(maxValueDp);
//
//            System.out.println();
//            Utils.print2DArray(countDp);

            if (countDp[0][0] == 0) {
                return new int[]{0, 0};
            }
            return new int[]{(int) (maxValueDp[0][0] % MOD), (int) (countDp[0][0] % MOD)};
        }


        private long max(long a, long b, long c) {
            return Math.max(Math.max(a, b), c);
        }

        private long getValue(long[][] dp, int x, int y) {
            if (x < 0 || y < 0 || x >= dp.length || y >= dp[0].length) {
                return Integer.MIN_VALUE;
            }
            return dp[x][y];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

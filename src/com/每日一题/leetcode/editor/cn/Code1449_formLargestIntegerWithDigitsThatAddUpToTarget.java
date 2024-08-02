package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-09 17:02:39
 * 题目名称: 数位成本和为目标值的最大数字
 * 题目类型:
 * 思考:
 */
public class Code1449_formLargestIntegerWithDigitsThatAddUpToTarget {
    public static void main(String[] args) {
        Solution solution = new Code1449_formLargestIntegerWithDigitsThatAddUpToTarget().new Solution();

        int[] cost = {13, 12, 9, 12, 15, 11, 10, 11, 15};

        String s = solution.largestNumber(cost, 52);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] cost, int target) {
            int[] costSelect = new int[cost.length + 1];
            System.arraycopy(cost, 0, costSelect, 1, cost.length);

            Data[][] dp = new Data[costSelect.length][target + 1];

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = new Data(0, 0, "");
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j] = null;
                        continue;
                    }

                    if (j == 0) {
                        dp[i][j] = new Data(0, 0, "");
                        continue;
                    }

                    // 不选
                    Data unSelect = dp[i - 1][j];
                    // 选择
                    if (j - costSelect[i] >= 0 && dp[i][j - costSelect[i]] != null) {
                        Data select = dp[i][j - costSelect[i]];
                        Data newSelect = new Data(select.digit + 1, select.digitSum + i, +i + select.digitString);
                        dp[i][j] = getMax(unSelect, newSelect);
                    } else {
                        dp[i][j] = unSelect;
                    }
                }
            }

//            for (int i = 0; i < dp.length; i++) {
//                for (int j = 0; j < dp[0].length; j++) {
//                    if (dp[i][j] != null) {
//                        System.out.print(dp[i][j].digitString + ", ");
//
//                    } else {
//                        System.out.print("null, ");
//
//                    }
//                }
//                System.out.println();
//            }
//
//            System.out.print("----");
//
//            for (int i = 0; i < dp.length; i++) {
//                for (int j = 0; j < dp[0].length; j++) {
//                    if (dp[i][j] != null) {
//                        System.out.print(dp[i][j].digit + ", ");
//
//                    } else {
//                        System.out.print("null, ");
//
//                    }
//                }
//                System.out.println();
//            }
//
//            System.out.print("----");
//
//            for (int i = 0; i < dp.length; i++) {
//                for (int j = 0; j < dp[0].length; j++) {
//                    if (dp[i][j] != null) {
//                        System.out.print(dp[i][j].digitSum + ", ");
//
//                    } else {
//                        System.out.print("null, ");
//
//                    }
//                }
//                System.out.println();
//            }

            Data data = dp[dp.length - 1][dp[0].length - 1];
            if (data == null) {
                return "0";
            }

            return data.digitString;
        }


        private Data getMax(Data a, Data b) {
            if (a == b) {
                return a;
            }
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }

            if (a.digitString.length() > b.digitString.length()) {
                return a;
            } else if (a.digitString.length() < b.digitString.length()) {
                return b;
            }

            for (int i = 0; i < a.digitString.length(); i++) {
                if (a.digitString.charAt(i) > b.digitString.charAt(i)) {
                    return a;
                } else if (a.digitString.charAt(i) < b.digitString.charAt(i)) {
                    return b;
                }
            }
            return a;
        }

        class Data {
            public int digit;
            public int digitSum;
            public String digitString;

            public Data(int digit, int digitSum, String digitString) {
                this.digit = digit;
                this.digitSum = digitSum;
                this.digitString = digitString;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

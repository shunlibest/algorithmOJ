package com.每日一题.leetcode.editor.cn;

import com.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [每日一题] 2024-07-22 10:32:19
 * 题目名称: 无矛盾的最佳球队
 * 题目类型:
 * 思考:
 */
public class Code1626_bestTeamWithNoConflicts {
    public static void main(String[] args) {
        Solution solution = new Code1626_bestTeamWithNoConflicts().new Solution();
        int[] scores = {1, 3, 7, 3, 2, 4, 10, 7, 5};
        int[] ages = {4, 5, 2, 1, 1, 2, 4, 1, 4};

        int i = solution.bestTeamScore(scores, ages);
        System.out.println(i);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            Data[] data = new Data[scores.length];

            for (int i = 0; i < scores.length; i++) {
                data[i] = new Data(scores[i], ages[i]);
            }

            Arrays.sort(data, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    if (o1.age == o2.age) {
                        return Integer.compare(o1.score, o2.score);
                    }
                    return Integer.compare(o1.age, o2.age);
                }
            });

            int[] dp = new int[data.length];

//            System.out.println(Arrays.toString(Arrays.stream(data).map(it -> it.age).toArray()));
//            System.out.println(Arrays.toString(Arrays.stream(data).map(it -> it.score).toArray()));

            for (int i = 0; i < data.length; i++) {
                dp[i] = data[i].score;
                for (int j = 0; j < i; j++) {
                    if (data[i].score >= data[j].score || data[i].age == data[j].age) {
                        dp[i] = Math.max(dp[i], dp[j] + data[i].score);
                    }
                }
            }

//            Utils.printTable(dp);

            int max = 0;
            for (int score : dp) {
                max = Math.max(max, score);
            }

            return max;

        }

        class Data {
            public int score;
            public int age;

            public Data(int score, int age) {
                this.score = score;
                this.age = age;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

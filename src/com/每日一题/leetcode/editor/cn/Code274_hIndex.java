package com.每日一题.leetcode.editor.cn;

import com.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * [每日一题] 2024-09-03 17:34:48
 * 题目名称: H 指数
 * 题目类型:
 * 思考:
 */


public class Code274_hIndex {
    public static void main(String[] args) {
        Solution solution = new Code274_hIndex().new Solution();
        int[] i0 = {4, 4, 0, 0};
        int i = solution.hIndex(i0);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);

            for (int i = 0; i < citations.length / 2; i++) {
                int temp = citations[i];
                citations[i] = citations[citations.length - i - 1];
                citations[citations.length - i - 1] = temp;
            }

//            Utils.printTable(citations);

            for (int i = 0; i < citations.length; i++) {

                int count = citations.length - i;

                if (i + 1 >= citations[i]) {
                    return i + 1;
                }
            }

            return citations.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

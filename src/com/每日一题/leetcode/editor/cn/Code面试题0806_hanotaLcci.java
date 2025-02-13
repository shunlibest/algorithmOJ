package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-08-12 14:22:27
 * 题目名称: 汉诺塔问题
 * 题目类型:
 * 思考:
 */


public class Code面试题0806_hanotaLcci {
    public static void main(String[] args) {
        Solution solution = new Code面试题0806_hanotaLcci().new Solution();
//        Object i0 = ;
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        a.add(0);
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        solution.hanota(a, b, c);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            moveFrom(A,B,C);

            // 先移动最后一个
        }

        private void moveFrom(List<Integer> A, List<Integer> B, List<Integer> C) {
//            boolean add = aim.add(src.get(src.size() - 1));

//            aim.add(src.get(src.size() - 1));
//
//
//            src.remove(src.size() - 1);
//            temp = src;
//            src = null;
//
//
//            System.out.println();

            System.out.println("开始移动");
            Utils.printTable(A);
            Utils.printTable(B);
            Utils.printTable(C);

            if (A.isEmpty()) {
                return;
            }


            moveFrom(A, C, B); // 移动A 上面的元素

            C.add(A.remove(A.size() - 1));

            moveFrom(B, A, C); //再将 B 上的 n-1 个圆盘经由A移到 C上

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

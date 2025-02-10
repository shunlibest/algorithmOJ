package com.每日一题.leetcode.editor.cn;

import com.Utils;
import com.二叉树.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * [每日一题] 2024-10-22 16:31:44
 * 题目名称: 二叉树的最大深度
 * 题目类型:
 * 思考:
 */


public class Code104_maximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Code104_maximumDepthOfBinaryTree().new Solution();
        Integer[] i0 = {3, 9, 20, null, null, 15, 7};
        TreeNode tree = TreeNode.array2Tree(i0);

//        Utils.printTable(tree);

        int i = solution.maxDepth(tree);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

            queue.add(new Pair<>(root, 1));

            int result = 0;
            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> poll = queue.poll();
//                int level = queue.poll().getValue();


                TreeNode node = poll.getKey();
                int level = poll.getValue();


                result = Math.max(result, level);
                if (node.left != null) {
                    queue.add(new Pair<>(node.left, level + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, level + 1));
                }
            }


            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

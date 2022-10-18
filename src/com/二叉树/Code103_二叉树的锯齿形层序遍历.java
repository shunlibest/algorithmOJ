package com.二叉树;

import com.排序算法.插入排序;

import java.util.*;

public class Code103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(17);

        treeNode1.left = treeNode2;

        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        List<List<Integer>> lists = zigzagLevelOrder(treeNode1);
        for (List<Integer> arrayInteger : lists) {
            for (Integer value : arrayInteger) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();

        List<List<Integer>> res = new ArrayList<>();

        que.add(root);
        boolean needReverse = false;
        while (!que.isEmpty()) {
            int parentNum = que.size();
            List<Integer> list = new ArrayList<>(parentNum);
            for (int i = 0; i < parentNum; i++) {
                TreeNode remove = que.remove();

                list.add(remove.val);
                if (remove.left != null) {
                    que.add(remove.left);
                }
                if (remove.right != null) {
                    que.add(remove.right);
                }
            }
            if (needReverse) {
                Collections.reverse(list);
            }
            needReverse = !needReverse;
            res.add(list);
        }
        return res;
    }


}

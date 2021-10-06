package com.二叉树;

import java.util.*;

public class Code102_二叉树的层序遍历 {


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        levelOrder(null);
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();

        List<List<Integer>> res = new ArrayList<>();

        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode poll = que.poll();
                itemList.add(poll.val);
                if (poll.left != null) {
                    que.offer(poll.left);

                }
                if (poll.right != null) {
                    que.offer(poll.right);

                }
                len--;
            }
            res.add(itemList);
        }

        return res;
    }

}

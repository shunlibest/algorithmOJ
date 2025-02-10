package com.二叉树;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode array2Tree(Integer[] array) {
        List<TreeNode> nodeList = new ArrayList<>(array.length);
        for (Integer n : array) {
            if (n == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(n));
            }
        }
        for (int i = 0; i < array.length / 2; i++) {
            TreeNode treeNode = nodeList.get(i);
            if (treeNode == null) {
                continue;
            }
            if (2 * i + 1 < array.length) {
                treeNode.left = nodeList.get(2 * i + 1);
            }
            if (2 * i + 2 < array.length) {
                treeNode.right = nodeList.get(2 * i + 2);
            }
        }
        return nodeList.get(0);
    }


}
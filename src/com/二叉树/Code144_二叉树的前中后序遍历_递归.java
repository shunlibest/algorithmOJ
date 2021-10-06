package com.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code144_二叉树的前中后序遍历_递归 {


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        preorderTraversal(treeNode1);
    }

    /**
     * 确定递归函数的参数和返回值：确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数，并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
     * 确定终止条件: 一定要有
     * 确定单层递归的逻辑： 确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。
     */

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        前序遍历(root, res);

        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void 前序遍历(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        前序遍历(root.left, result);
        前序遍历(root.right, result);
        result.add(root.val);
    }

    public static void 中序遍历(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        中序遍历(root.left, result);
        中序遍历(root.right, result);
        result.add(root.val);
    }

    public static void 后序遍历(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        后序遍历(root.left, result);
        后序遍历(root.right, result);
        result.add(root.val);
    }


}

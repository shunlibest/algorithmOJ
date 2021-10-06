package com.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Code144_二叉树的前中后序遍历_非递归 {


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        preorderTraversal(treeNode1);
    }


    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        前序遍历(root, res);

        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void 前序遍历(TreeNode root, List<Integer> result) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop == null) {
                continue;
            }
            result.add(pop.val);
            stack.push(pop.right);
            stack.push(pop.left);
        }
    }

    public static void 中序遍历(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode tempNode = root;


        while (!stack.isEmpty() || tempNode != null) {
            if (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);

                tempNode = pop.right;
            }

        }

    }

    public static void 后序遍历(TreeNode root, List<Integer> result) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode tempNode = root;

        while (!stack.isEmpty() || tempNode != null) {
            if (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.right != null) {
                    stack.push(pop);
                    tempNode = pop.right;
                    continue;
                }
                result.add(pop.val);

                tempNode = pop.right;
            }

        }
    }


}

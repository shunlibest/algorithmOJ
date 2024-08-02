package com.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Code894_所有可能的真二叉树 {
    public static void main(String[] args) {
        List<TreeNode> nodeList = new Code894_所有可能的真二叉树().allPossibleFBT(3);
        for (TreeNode node : nodeList) {
            System.out.println(node);
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> nodeList = getNodeList(n);
        return nodeList;
    }


    private List<TreeNode> getNodeList(int n) {
        List<TreeNode> resNode = new ArrayList<>();

        if (n == 1) {
            resNode.add(new TreeNode(0));
            return resNode;
        }
        // 获取左边节点的列表
        if (n == 0 || (n - 1) % 2 != 0) {
            return new ArrayList<>();
        }
        n = n - 1;
        for (int i = 1; i <= n; i += 2) {
            List<TreeNode> leftNode = getNodeList(i);
            List<TreeNode> rightNode = getNodeList(n - i);

            for (TreeNode left : leftNode) {
                for (TreeNode right : rightNode) {
                    TreeNode rootNode = new TreeNode(0);
                    rootNode.left = left;
                    rootNode.right = right;
                    resNode.add(rootNode);
                }
            }
        }
        return resNode;
    }
}

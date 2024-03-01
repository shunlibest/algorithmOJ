package com.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Code235_二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.array2Tree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

        TreeNode common = new Code235_二叉搜索树的最近公共祖先().lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(8));


        System.out.println(common.val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (p.val < current.val && q.val < current.val){
                current = current.left;
            }else  if (p.val > current.val && q.val > current.val){
                current = current.right;
            }else {
                return current;
            }
        }
        return null;
    }
}

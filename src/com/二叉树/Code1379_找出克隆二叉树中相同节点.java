package com.二叉树;

public class Code1379_找出克隆二叉树中相同节点 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.array2Tree(new Integer[]{7, 4, 3, null, null, 6, 19});
        TreeNode copy = TreeNode.array2Tree(new Integer[]{7, 4, 3, null, null, 6, 19});
        TreeNode targetCopy = new Code1379_找出克隆二叉树中相同节点().getTargetCopy(node, copy, node.right);

        System.out.println(targetCopy.val);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        TreeNode leftNode = getTargetCopy(original.left, cloned.left, target);
        if (leftNode != null) {
            return leftNode;
        }


        TreeNode rightNode = getTargetCopy(original.right, cloned.right, target);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }
}

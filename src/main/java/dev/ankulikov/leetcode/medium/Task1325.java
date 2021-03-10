package dev.ankulikov.leetcode.medium;

import java.util.Objects;

public class Task1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return deleteAllLeavesWithTargetValue(root, target);
    }

    private TreeNode deleteAllLeavesWithTargetValue(TreeNode node, int target) {
        if (node.left != null) {
            node.left = deleteAllLeavesWithTargetValue(node.left, target);
        }
        if (node.right != null) {
            node.right = deleteAllLeavesWithTargetValue(node.right, target);
        }
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }
        return node;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) return false;
        if (!Objects.equals(left, treeNode.left)) return false;
        return Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}

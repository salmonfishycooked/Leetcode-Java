package com.leetcode._1026_Maximum_Difference_Between_Node_and_Ancestor;

/**
 * 深度优先搜索
 * 时间复杂度：O(n)
 * 空间复杂度：O(n) 最坏情况下，二叉树退化为链表，递归栈的空间为O(n)
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int max, int min) {
        if (node == null) return 0;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int maxSelf = Math.max(Math.abs(node.val - max), Math.abs(node.val - min));
        int maxLeft = dfs(node.left, max, min);
        int maxRight = dfs(node.right, max, min);
        return Math.max(Math.max(maxLeft, maxRight), maxSelf);
    }
}

package com.leetcode._1026_Maximum_Difference_Between_Node_and_Ancestor;

public class Test {
    public static void main(String[] args) {
        // root = [1,null,2,null,0,3]
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(0, node1, null);
        TreeNode node3 = new TreeNode(2, null, node2);
        TreeNode root = new TreeNode(1, null, node3);

        Solution solution = new Solution();
        System.out.println(solution.maxAncestorDiff(root));
    }
}

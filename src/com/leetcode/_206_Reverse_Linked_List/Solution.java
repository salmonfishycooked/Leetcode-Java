package com.leetcode._206_Reverse_Linked_List;

/**
 * 迭代解法
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }
}

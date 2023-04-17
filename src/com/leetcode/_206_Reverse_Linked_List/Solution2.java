package com.leetcode._206_Reverse_Linked_List;

/**
 * 递归解法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)，开销主要取决于递归调用的栈空间，最多为 n 层
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

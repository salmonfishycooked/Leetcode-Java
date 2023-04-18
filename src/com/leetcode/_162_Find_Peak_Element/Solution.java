package com.leetcode._162_Find_Peak_Element;

/**
 * 二分查找
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int l = -1, r = nums.length - 1;
        while (l + 1 != r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
}

package com.leetcode._154_Find_Minimum_in_Rotated_Sorted_Array_II;

/**
 * 需要预处理的二分查找
 * 时间复杂度：平均时间复杂度为 O(logn)
 * 在最坏情况下，也就是当数组中的元素完全相同的时候，对右递增数组的预划分操作的时间复杂度达到 O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int l = -1, r = nums.length;
        while (l + 1 != r && nums[0] == nums[r - 1]) r--;
        while (l + 1 != r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid;
        }
        if (l == nums.length - 1) return nums[0];
        return nums[r];
    }
}

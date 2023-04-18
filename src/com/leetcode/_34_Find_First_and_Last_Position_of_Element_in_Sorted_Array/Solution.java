package com.leetcode._34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target) + 1;
        int right = binarySearch(nums, target + 1);
        if (left > right) return new int[]{-1, -1};
        return new int[]{left, right};
    }

    // 返回小于 val 的最大索引
    private int binarySearch(int[] nums, int val) {
        int l = -1, r = nums.length;
        while (l + 1 != r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < val) l = mid;
            else r = mid;
        }
        return l;
    }
}

package com.leetcode._153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution {
    public int findMin(int[] nums) {
        int l = -1, r = nums.length;
        while (l + 1 != r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid;
        }
        if (l == nums.length - 1) return nums[0];
        return nums[r];
    }
}

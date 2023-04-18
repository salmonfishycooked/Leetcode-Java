package com.leetcode._1_Two_Sum;

/**
 * 一般思路，暴力枚举
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int key;
        for (int i = 0; i < nums.length; ++i) {
            key = target - nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == key) return new int[]{i, j};
            }
        }
        return null;
    }
}

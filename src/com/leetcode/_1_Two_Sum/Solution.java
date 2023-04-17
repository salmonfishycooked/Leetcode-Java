package com.leetcode._1_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希映射解法
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

package com.leetcode._1_Two_Sum;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] ans = solution.twoSum(nums, target);

        System.out.println(Arrays.toString(ans));
    }
}

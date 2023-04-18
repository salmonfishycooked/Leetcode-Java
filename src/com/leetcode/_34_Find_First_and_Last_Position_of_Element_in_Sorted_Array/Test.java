package com.leetcode._34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }
}

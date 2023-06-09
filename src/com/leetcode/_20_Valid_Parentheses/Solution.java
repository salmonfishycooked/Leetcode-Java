package com.leetcode._20_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * 栈 + 哈希映射
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.peek() != map.get(ch)) return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

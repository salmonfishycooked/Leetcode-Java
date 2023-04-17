# [20. Valid Parentheses](https://leetcode.cn/problems/valid-parentheses)

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

 

**Example 1:**

```
Input: s = "()"
Output: true
```

**Example 2:**

```
Input: s = "()[]{}"
Output: true
```

**Example 3:**

```
Input: s = "(]"
Output: false
```

 

**Constraints:**

- `1 <= s.length <= 104`
- `s` consists of parentheses only `'()[]{}'`.



## 解法一：栈

首先我们要想到，一个左括号进去，如果这个字符串是满足条件的，必定会有一个右括号对应。

但是，括号里面可能存在嵌套的关系，即**后进的左括号先匹配到对应的右括号**，这个时候我们可以考虑用栈这个数据结构来辅助实现算法。

先创建一个栈实例（这里用 `ArrayDeque`）

```java
ArrayDeque<Character> stack = new ArrayDeque<>();
```

然后我们需要遍历这个字符串，**如果是左括号可以直接入栈，如果是右括号则需要进行匹配**，匹配成功后进行出栈操作。当然，这里我们不必要去一个个写该字符等于右括号的所有情况，可以建立一个哈希表。

```java
Map<Character, Character> map = new HashMap<>(){{
    put(')', '(');
    put(']', '[');
    put('}', '{');
}};
```

```java
for (char ch : s.toCharArray()) {
    if (map.containsKey(ch) && stack.peek() == map.get(ch)) {
        stack.pop();
    } else {
        stack.push(ch);
    }
}
```

但是，这个算法可以进行进一步优化，我们可以想到，如果此时栈顶与这个右括号不相匹配的话，则这个字符串必定不满足条件。所以算法可以优化为

```java
for (char ch : s.toCharArray()) {
    if (map.containsKey(ch)) {
        if (stack.peek() != map.get(ch)) return false;
        stack.pop();
    } else {
        stack.push(ch);
    }
}
```

循环完成后，我们不知道栈里面是否还有剩余的左括号没匹配完，这时候就需要检查栈是否为空。我们直接返回 `stack.isEmpty()` 即可。



完整代码如下

```java
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
```

> 时间复杂度：$O(n)$

时间开销主要在遍历字符串上

> 空间复杂度：$O(n)$

空间开销主要在新建栈实例所开辟的空间上（哈希表所开辟的字符集只是有限个）
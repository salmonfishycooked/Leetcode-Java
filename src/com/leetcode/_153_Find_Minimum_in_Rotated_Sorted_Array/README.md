# [153. Find Minimum in Rotated Sorted Array](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array)

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:

- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of **unique** elements, return *the minimum element of this array*.

You must write an algorithm that runs in `O(log n) time.`

 

**Example 1:**

```
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
```

**Example 3:**

```
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
```

 

**Constraints:**

- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- All the integers of `nums` are **unique**.
- `nums` is sorted and rotated between `1` and `n` times.



## 解法一：二分查找

二分查找通用思路详见： [LeetCode 162 寻找峰值题解](https://leetcode.cn/problems/find-peak-element/solutions/2233025/xun-zhao-feng-zhi-tong-yong-er-fen-cha-z-sjra/)

因为这里的 `nums` 中的所有整数**互不相同**，所以我们可以用 **left** 来划分左边的递增数组，**right** 来划分右边的递增数组，这里的条件为 `nums[mid] >= nums[0]` ，`nums[0]` 为左边的递增数组的最小值。

满足这个条件的，划分给 **left**，不满足的划分给 **right**。

如果最后只有左边的递增数组，没有右边的递增数组，即 `right = num.length`，返回 `nums[0]` 即可。否则返回右边的递增数组的最小值，即 `nums[right]` 。

完整代码如下

```java
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
```

> 时间复杂度：$O(logn)$
>
> 空间复杂度：$O(1)$
# [154. Find Minimum in Rotated Sorted Array II](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii)

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,4,4,5,6,7]` might become:

- `[4,5,6,7,0,1,4]` if it was rotated `4` times.
- `[0,1,4,4,5,6,7]` if it was rotated `7` times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` that may contain **duplicates**, return *the minimum element of this array*.

You must decrease the overall operation steps as much as possible.

 

**Example 1:**

```
Input: nums = [1,3,5]
Output: 1
```

**Example 2:**

```
Input: nums = [2,2,2,0,1]
Output: 0
```

 

**Constraints:**

- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- `nums` is sorted and rotated between `1` and `n` times.



## 解法一：二分查找

同 [LeetCode 153 寻找旋转排序数组中的最小值 题解](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/2233216/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-ff0mp/)

只是我们需要注意，在 153 题中我们的数组是没有重复的值的，所以让我们看看如果出现重复值情况会怎么样。

例1

```java
num = [5, 5, 5, 1, 5]
```

我们的算法对于这个例1是没有问题的

例2

```java
num = [5, 1, 5, 5, 5]
```

我们的算法对于这个例2就会出点问题了。

我们知道当 `nums[mid] > nums[0]` 时，**mid** 绝对是属于 **left** 所管理的递增数组，

但是问题就出在 `nums[mid] = nums[0]` 上，这个时候对于你不知道给 **mid** 划分到哪个区域，如例1，例2。

所以我们需要将这种情况先筛选出来，将右递增数组的区域先做一个预划分。

```java
while (l + 1 != r && nums[0] == nums[r - 1]) r--;
```

我们拿例2举例，筛选过后 **left** 还是 -1，**right** 从 5 变成了 2。

也就是说我们接下来的二分查找只需要在 (-1, 2) 中划分区域就好了。即 [5, 1] 中，

这个时候右递增数列不会出现 `nums[mid] = nums[0]` 的现象，所以出现相等的时候应该划分为 `left` 区域。



所以完整代码如下

```java
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
```

> 时间复杂度：平均时间复杂度为 $O(logn)$。在最坏情况下，也就是当数组中的元素完全相同的时候，对右递增数组的预划分操作的时间复杂度达到 $O(n)$。
>
> 空间复杂度：$O(1)$
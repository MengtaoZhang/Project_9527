/**
 * 下一个排列
 * 给定一个若干整数的排列，给出按整数大小进行字典序从小到大排序后的下一个排列。若没有下一个排列，则输出字典序最小的序列。
 * 从末尾往左走，如果一直递增，例如 {...9,7,5} ，那么下一个排列一定会牵扯到左边更多的数，直到一个非递增数为止，例如 {...6,9,7,5} 。对于原数组的变化就只到 6 这里，
 * 和左侧其他数再无关系。6 这个位置会变成6右侧所有数中比 6 大的最小的数，而 6 会进入最后 3 个数中，且后 3 个数必是升序数组。
 * 
 * 算法步骤如下：
 * 1. 从右往左遍历数组 nums，直到找到一个位置 i ，满足 nums[i] > nums[i - 1] 或者 i 为 0 。
 * i 不为 0 时，用j再次从右到左遍历 nums ，寻找第一个 nums[j] > nums[i - 1] 。而后交换 nums[j] 和 nums[i - 1] 。注意，满足要求的 j 一定存在！且交换后 nums[i] 及右侧数组仍为降序数组。
 * 将 nums[i] 及右侧的数组翻转，使其升序。
 */

// for swap nums[i] and nums[j]
public void swapItem(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

// 用于翻转nums[i] 到 nums[j], 包含两端的这一小段数组
public void swapList(int[] nums, int i, int j) {
    while (i < j) {
        swapItem(nums, i, j);
        i++;
        j--;
    }
}

public void nextPermutation(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
        return;
    }
    int i = len - 1;
    while (i > 0 && nums[i] <= nums[i - 1]) {
        i--;
    }
    if (i != 0) {
        int j = len - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swapItem(nums, j, i - 1);
    }
    swapList(nums, i, len - 1);
}




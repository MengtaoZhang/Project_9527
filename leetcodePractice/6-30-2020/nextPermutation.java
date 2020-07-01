/**
求下一个排列
 */

// 用于交换 nums[i] and nums[j]
public void swapItem(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

// 用于翻转nums[i]到nums[j], 包含两端的这一小段数组
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
    while(i > 0 && nums[i] <= nums[i - 1]) {
        i--;
    }    
    if (i != 0) {
        int j = len - 1;
        while (nums[j] <= nums[i - 1]) {
            j --;
        }
        swapItem(nums, j, i - 1);
    }
    swapList(nums, i, len - 1);
}
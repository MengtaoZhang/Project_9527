/**
 * 用模版解决数组去重问题
 */

public int deduplication(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    Arrays.sort(nums);
    int i, j = 1;
    for (i = 0; i < nums.length; i++) {
        while (j < nums.length && nums[i] == nums[j]) {
            j++;
        }
        if (j >= nums.length) {
            continue;
        }
        nums[i + 1] = nums[j];
    }
    
    return i + 1;
}
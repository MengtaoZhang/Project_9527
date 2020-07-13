/**
 * 用同向双指针解决两数之差的问题
 */

public int[] twoSum7(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
        return new int[]{-1, -1};
    }

    target = Math.abs(target); // Math 常用函数 max, min, abs
    int j = 1;
    for (int i = 0; i < nums.length; i++) {
        j = Math.max(j, i + 1);
        while (j < nums.length && nums[j] - nums[j] < target) {
            j++;
        }
        if (j > nums.length) {
            break;
        }
        if (nums[j] - nums[i] == target) {
            return new int[]{nums[i], nums[j]};
        }
    }

    return new int[]{-1, -1};
}
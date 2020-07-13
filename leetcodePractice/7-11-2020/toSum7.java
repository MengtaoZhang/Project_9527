/**
 * 使用哈希表的替代品解决两数之差问题
 */

public int[] twoSum7(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
        return new int[]}{-1, -1};
    }

    target = Math.abs(target);
    for (int i = 0; i < nums.length; i++) {
        int j = binarySearch
    }
}

public int binarySearch(int[] nums, int start, int end, int target) {
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;  // 防止越界
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            start = mid;
        } else {
            end = mid;
        }
    }

    if (nums[start] == target) {
        return start;
    }
    if (nums[end] == target) {
        return end;
    }

    return -1;
}
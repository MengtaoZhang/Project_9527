/**
 * 使用同向双指针模版解决滑动窗口问题
 */

public int[] winSum(int[] nums, int k) {
    if (nums == null || nums.length < k) {
        return new int[]{};
    }
    if (k == 0) {
        return new int[]{nums.length};
    }

    int[] results = new int[nums.length];
    int j = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
        while (j < nums.length && j - i < k) {
            sum += nums[j];
            j++;
        } 
        if (j - i == k) {
            results[i] = sum;
        }
        sum -= nums[i];
    }

    return results;
}
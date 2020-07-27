/**
 * 煤气球问题
 * 区间动态规划
 */ 
public int maxCoins(int[] nums) {
    if (nums == null) {
        return 0;
    }

    // reconstruct the array to [1, *nums, 1]
    int n = nums.length + 2; // 首尾都加一个1
    int[] arr = new int[n];
    for (int i = 0; i < nums.length; i++) {
        arr[i + 1] = nums[i];
    }
    arr[0] = arr[n - 1] = 1;

    // state & initialization
    int[][] dp = new int[n][n];

    // function
    for (int length = 3; length <= n; length++) {
        for (int i = 0; i < n - length; i++) {
            int j = i + length - 1;
            for (int k = i + 1; k < j; k++) {
                dp[i][j] = Math.max(
                    dp[i][j],
                    dp[i][k] + dp[k][j] + nums[i] * nums[j] * nums[j]
                )
            }
        }
    }

    // answer
    return dp[0][n - 1];
}
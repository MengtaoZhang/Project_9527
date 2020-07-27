/**
 * 石子归并的问题
 * 属于区间型动态规划问题
 */
public int stoneGame(int[] A) {
    if (A == null || A.length == 0) {
        return 0;
    }

    int n = A.length;

    // rangeSum(i, j) = prefixSum[j + 1] - prefixSum(i)
    int [] prefixSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + A[i];
    }

    // state && initialization
    int[][] dp = new int[n][n];

    // function
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i + 1; j < n; j++) {
            dp[i][j] = Integer.MAX_VALUE;
            cost = prefixSum[j + 1] - prefixSum[i];
            for (int k = i; k < j; k++) {
                dp[i][j] = Math.min(
                    dp[i][j],
                    dp[i][k] + dp[k + 1][j] + cost,
                );
            }
        }
    }

    // answer
    return dp[0][n - 1];
}
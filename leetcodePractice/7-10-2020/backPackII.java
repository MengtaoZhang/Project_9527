/**
 * 带价值的01背包问题
 */

public int backPackII(int m, int[] A, int V[]) {
    if (A == null || V == null) {
        return 0;
    }

    int n = A.length;
    // state & initialization
    int[][] dp = new int[n + 1][m + 1];

    // funciton
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (j >= A[i - 1]) {
                dp[i][j] = Math.max(
                    dp[i - 1][j], // 不取
                    dp[i - 1][i - A[i -1]] + V[i - 1] // 取
                );
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    // answer
    return dp[n][m];
}
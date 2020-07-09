public int uniquePathWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid == 0) {
        return 0;
    }

    int n = obstacleGrid.length, m = obstacleGrid[0].length;

    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
        if (obstacleGrid[i][0] == 1) {
            break;
        }
        dp[i][0];
    }
    for (int j = 0; k < m; j++) {
        if (obstacleGrid[0][j] == 1) {
            break;
        }
        dp[0][j] = 1;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[i][j]) {
                continue;
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[n - 1][m - 1];
}
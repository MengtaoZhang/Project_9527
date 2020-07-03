public int uniquePaths(int m, int n) {
    // state: dp[i][j] 代表0，0 走到i，j的方案数
    // 自顶向下的版本

    
    int[][] dp = new int[m][n];

    // initialize
    for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (int j = 0; i < n; j++) {
        dp[0][j] = 1;
    }

    // function
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    
    // answer
    return dp[m - 1][n - 1];
}
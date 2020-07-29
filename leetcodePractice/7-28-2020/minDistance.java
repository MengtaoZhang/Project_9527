/**
 * 匹配型动态规划
 * 编辑距离
 * edit-distance
 */
public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
        return -1;
    }

    int n = word1.length();
    int m = word2.length();

    int[][] dp = new int[n + 1][m + 1];

    // initialization
    for (int i = 0; i < m + 1; i++) {
        dp[0][i] = i;
    }
    for (int i = 0; i < n + 1; i++) {
        dp[i][0] = i;
    }

    // function
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = Math.min(
                    dp[i - 1][j - 1];
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                );
            } else {
                dp[i][j] = Math.min(
                    dp[i - 1][j - 1] + 1,
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1)
                );
            }
        }
    }

    // answer
    return dp[n][m];
}
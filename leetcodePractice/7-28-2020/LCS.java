/**
 * 匹配型动态规划
 * 最长公共子序列
 */
public int longestCommonSubsequence(String A, String B) {
    if (A == null || B == null) {
        return 0;
    }

    int n = A.length(), m = B.length();

    // state: dp[i][j] 表示A序列的前 i 个， 与 B 序列的前 j 个的LCS长度
    // initialization: 初始值为0
    int dp[][] = new int[n + 1][m + 1];

    // function
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
    }

    // answer
    return dp[n][m];
}
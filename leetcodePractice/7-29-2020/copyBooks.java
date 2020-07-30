/**
 * 划分型动态规划
 * 复印书籍的代码实现
 */
public int copyBooks(int[] pages, int k) {
    if (pages == null || pages.length == 0 || k == 0) {
        return 0;
    }

    int n = pages.length;

    // 计算前缀和
    int[] prefixSum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        prefixSum[i] = prefixSum[i - 1] + pages[i - 1];
    }

    // state: dp[i][j] 表示前 i 本书， 划分给 j 个人复印， 最少需要耗费多久
    int[][] dp = new int[n + 1][k + 1];

    // initialization
    for (int i = 1; i <= n; i++) {
        dp[i][0] = Integer.MAX_VALUE;
    }

    // function
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= k; j++) {
            dp[i][j] = Integer.MAX_VALUE;
            for (int prev = 0; prev < i; prev++) {
                int cost = prefixSum[i] - prefixSum[prev];
                dp[i][j] = Math.min(dpp[i][j], Math.max(dp[prev][j - 1], cost));
            }
        }
    }
    // answer
    return dp[n][k];
}
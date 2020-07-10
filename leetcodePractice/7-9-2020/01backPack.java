/**
01背包问题
 */

public int backPack(int m, int[] A) {
    int n = A.length;

    //state: dp[i][j] 前i个数里能否挑出和为j
    boolean[][] dp = new boolean[n + 1][m + 1];

    // initialize: 前 0 个数里挑和为0是true，其余都是false
    dp[0][0] = true;

    // function
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (j >= A[i - 1]) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i]];
            } else {
                dp[i][j] = dp[i - 1][j];   //如果加上dp[i] 结果就大于m了
            }
        }
    }

    // answer
    for (int v = m; v >= 0; v--) {
        if (dp[n][v]) {
            return v;
        }
    }
    return -1;
}
/**
骑士最短路径
 */

public static int[] deltaX = {1, -1, 2, -2};
public static int[] deltaY = {-2, -2, -1, -1};

public int shortestPath2(boolean[][] grid) {
    if (grid == null || grid.length == 0) {
        return -1;
    }

    int n = grid.length, m = grid[0].length;

    //state: dp[i][j] 表示从0， 0 跳到i， j的最短距离
    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dp[i][j] = Integer.MAX_VALUEl
        }
    }
    dp[0][0] = 0;

    //function
    for (int j = 0; j < m; j++) {
        for (int direction = 0; direction < 4; direction++) {
            int x = i + deltaX[direction];
            int y = j + deltaY[direction];
            if (x < 0 || x >= n || y < 0 || y >= m) {
                continue;
            }
            if (dp[x][y] == Integer.MAX_VALUEl) {
                continue;
            }
            dp[i][j] = Math.min(dp[i][j], dp[x][y] + 1);
        }
    }
    if (dp[n - 1][m - 1] == Integer.MAX_VALUEl) {
        return -1;
    }
    return dp[n - 1][m - 1];
}

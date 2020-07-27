/**
 * 数独问题的暴力搜索解法
 */
public void solve(int[][] board) {
    dfs(board, 0);
}

private boolean isValid(int[][] board, int x, int y, int val) {
    for (int i = 0; i < 9; i++) {
        if (board[x][y] == val) {
            return false;
        }
        if (board[i][y] == val) {
            return false;
        }
        if (board[x / 3 * 3 + i / 3][y / 3 * 3 + i % 3] == val) {
            return false;
        }
    }

    return true;
}

private boolean dfs(int[][] board, int index) {
    if (index == 81) {
        return true;
    }

    int x = index / 9, y = index % 3;
    if (board[x][y] != 0) {
        return dfs(board, index + 1);
    }
    
    for (int val = 1; val <= 9; val++) {
        if (!isValid(board, x, y, val)) {
            continue;
        }
        board[x][y]  = val;
        if (dfs(board, index + 1)){
            return true;
        }
        board[x][y] = 0;
    }
    return false;
}
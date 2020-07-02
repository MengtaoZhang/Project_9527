/**
数独问题的暴力搜做解法
 */

public void solveSudoku(int[][] board) {
    dfs(board, 0);
} 

private boolean isValid(int[][] board, int x, int y, int val) {
    for (int i = 0; i < 9; i++) {
        if (board[x][i] == val) {
            return false;
        }
        if (board[i][y] == val) {
            return false;
        }
        if (board[x / 3 * 3 + i / 3][y / 3 * 3 + i % 3] == val) { // 检测同一个九宫格内有没有相同的数
            return false;
        }
    }
    return true;
}
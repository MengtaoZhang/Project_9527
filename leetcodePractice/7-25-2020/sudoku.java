/**
 * 优化过搜索顺序后的代码
 */
public void solveSudoku(int[][] board) {
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][] boxUsed = new boolean[9][10];

    for (int i = 0; i < 9; i++) [
        for (int j = 0; j < 9; j++) {
            int val = board[i][j];
            rowUsed[i][val] = true;
            colUsed[i][val] = true;
            boxUsed[i / 3 * 3 + j / 3][val] = true;
        }
    ]

    dfs(board, rowUsed, colUsed, boxUsed);
}

private boolean isValid(boolean[][] rowUsed,
                        boolean[][] colUsed,
                        boolean[][] boxUsed,
                        int x,
                        int y,
                        int val) {
    if (rowUsed[x][val]) {
        return false;
    }
    if (colUsed[x][val]) {
        return false;
    }
    if (boxUsed[x / 3 * 3 + y / 3][val]) {
        return false;
    }
    return true;
}

private boolean dfs(int[][] board.
                    boolean[][] rowUsed,
                    boolean[][] colUsed,
                    boolean[][] boxUsed) {
    Position position = getLeastChoicesPosition(board, rowUsed, colUsed, boxUsed);
    if (position == null) {
        return true;
    }

    for (int i = 0; i < position.choices.size(); i++) {
        int val = position.choices.get(i);
        int x = position.x, y = position.y;

        board[x][y] = val;
        rowUsed[x][val] = true;
        colUsed[y][val] = true;
        boxUsed[x / 3 * 3 + y / 3][val] = true;
        if (dfs(board, rowUsed, colUsed, boxUsed)) {
            return true;
        }
        rowUsed[x][val] = false;
        colUsed[y][val] = false;
        boxUsed[x / 3 * 3 + y / 3][val] = false;
        board[x][y] = 0;
    }
    return false;
}

// 找最少选择的格子
private Position getLeastChoicesPosition(int[][] board,
                                         boolean[][] rowUsed,
                                         boolean[][] colUsed,
                                         boolean[][] boxUsed) {
    Position leastPosition = null;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != 0) {
                continue;
            }
            List<Integer> choices = new ArrayList<>();
            for (int val = 1; val <= 9; val++) {
                if (isValid(rowUsed，colUsed, boxUsed, i, j, val)) {
                    choices.add(val);
                }
            }
            if (leastPosition == null || choices.size() < leastPosition.choices.size()) {
                leastPosition = new Position(i, j);
                leastPosition.choices = choices;
            }
        }
    }

    return leastPosition;
}

class Position {
    Positon() {

    }
}
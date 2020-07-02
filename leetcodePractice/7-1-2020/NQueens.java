/**
N-Queens implementation
如果要优化的话，比较明显的地方是优化isValid函数，但是优化完没啥效果，
瓶颈仍然是Draw函数-> O(n^2)的复杂度
 */

List<List<String>> solveNQueens(int n) {
    // results is for storing answer
    List<List<String>> results = new ArrayList<>();
    if (n <= 0) {
        return results;
    } 

    search(results, new ArrayList<Integer>(), n);
    return results;
}

//search函数为搜索函数，n表示已经放置了N个皇后，cols表示每个皇后所在的列
private void search(List<List<String>> results, List<Integer> cols, int n) {
    // 若已经放置了n个皇后表示出现了一种解法，绘制后加入答案 results
    if (cols.size() == n) {
        results.add(Draw(cols));
        return;
    }

    // 枚举当前皇后放置的列，若不合法则跳过
    for (int colIndex = 0; colIndex < n; colIndex++) {
        if (!isValid(cols, colIndex)) {
            continue;
        }
        // 若合法则递归枚举下一行的皇后
        cols.add(colIndex);
        search(results, cols, n);
        cols.remove(cols.size() - 1);
    }
}

// isValid函数为合法性判断函数
private boolean isValid(List<Integer> cols, int col) {
    int row = cols.size();
    for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
        // 若有其他皇后在同一列或者同一斜线上则不合法
        if (cols.get(rowIndex) == col) {
            return false;
        }
        if (row + col == rowIndex + cols.get(rowIndex)) {
            return false;
        }
        if (row - col == rowIndex - cols.get(rowIndex)) {
            return false;
        }
    }
    return true;
}

// Draw函数为将 cols 数组转换为答案的绘制函数
private Lise<String> Draw(List<Integer> cols) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < cols.size(); i++) } {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols.size(); j++) {
            sb.append(j == cols.get(i) ? 'Q' : ".");
        }
        result.add(sb.toString());
    }
    return result;
}
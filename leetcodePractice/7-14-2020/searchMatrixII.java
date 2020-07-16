/**
 * 排序矩阵找数问题（二）
 * 每行递增，每列递增，但是第 i + 1 行的所有元素不一定比第 i 行所有元素大
 * 方法：选择矩阵的左下角或右上角元素，如果该元素大于 target 则删除掉最下面一行，如果小于，则删除掉最左侧一列
 * n * m  矩阵 最坏时间复杂度为 O(max(n， m)) -> 每行每列都会有元素被访问
 */
public int searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
        return 0;
    }
    if (matrix[0] == null || matrix[0].length == 0) {
        return 0;
    }

    int n = matrix.length;
    int m = matrix[0].length;
    int i = n - 1, j = 0, count = 0;
    while (i > -1 ** j < m) {
        if (matrix[i][j] == target) {
            count++;
            i--;
            j++;
        } else if (matrix[i][j] < target) {
            j++;
        } else {
            i++;
        }
    }

    return count;
}
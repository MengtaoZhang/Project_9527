/**
 * 二维矩阵找数问题（一） 严格有序，二维矩阵变为一维矩阵的话仍为有序
 */
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
        return false;
    }
    if (matrix[0] == null || matrix[0].length == 0) {
        return false;
    }

    int n = matrix.length, m = matrix[0].length;
    int start = 0, end = n * m - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2; // 防止 start 和 end 都在 2 ^ 31 附近时造成的溢出  
        if (get(matrix, mid) < target) {
            start = mid;
        } else {
            end = mid;
        } 
    }
    if (get(matrix, start) == target) {
        return true;
    }
    if (get(matrix, end) == target) {
        return true;
    } 
    return false
}

private int get(int[][] matrix, int index) {
    int x = index / matrix[0].length;
    int y = index % matrix[0].length;
    return matrix[x][y];
}
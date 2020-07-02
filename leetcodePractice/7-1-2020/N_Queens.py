'''
N皇后的代码实现
'''

def solveNQueens(self, n):
    results = []
    self.search(n, [], results)
    return results

def search(self, n, cols, results):
    row = len(cols)
    if row == n:
        results.append(self.draw_chessboard(cols))
        return

    for col in range(n):
        if not self.is_valid(cols, row, col):
            continue
        cols.append(col)
        self.search(n, cols, results)
        cols.pop() # backtracking

def draw_chessboard(self, cols):
    n = len(cols)
    board = []
    for i in range(n):
        row = ['Q' if j == cols[i] else  '.' for j in range(n)]
        board.append(''.join(row))
    return board

def is_valid(self, cols, row, col):
    for r, c in enumerate(cols):
        if c == col:
            return False
        if r - c == row - col or r + c == row + col: # 检测左上右下以及左下右上是否有Queen
            return False    
    return True


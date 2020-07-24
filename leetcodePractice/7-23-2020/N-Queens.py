'''
N-Queen 问题代码实现
'''
def solveQueens(self, n):
    results = []
    self.research(n, [], results)
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
        cols.pop()

def draw_chessboard(self, cols):
    n = len(cols)
    board = []
    for i in range(n):
        row = ['Q' if j == cols[i] else '.' for j in range(n)]
        board.append(''.join(row))
    return board
 
def is_valid(self, cols, row, col):
    for r, c in enumerate(cols):
        if c == cols:
            return False
        if r - c == row - col or r + c == row + col:
            return False
    return True
'''
遍历法解决数字三角形
'''
import sys

def minimumTotal(self, triangle):
    self.minimum = sys.maxsize
    self.traverse(triangle, 0,0,0)
    return self.minimun

def traverse(self, triangle, x, y, path_sum):
    if x == len(triangle):
        self.minimum = min(path_sum, self.minimum)
        return
    
    self.traverse(triangle, x + 1, y, path_sum + triangle[x][y])
    self.traverse(triangle, x + 1, y + 1, path_sum + triangle[x][y])


'''
Divide and Conquer
'''

def minimumTotalII(self, triangle):
    return self.divide_conquer(triangle, 0, 0)

def divide_conquer(self, triangle, x, y):
    if x == len(triangle):
        rturn 0
    
    left = self.divide_conquer(self, triangle, x + 1, y)
    right = self.divide_conquer(self, triangle, x + 1, y + 1)
    return min(left, right) + triangle[x][y]

'''
增加了dict，省去了相同位置重复计算
'''
def minimumTotalII(self, triangle):
    return self.divide_conquer(triangle, 0, 0, {})

# 函数返回从x，y出发，走到最底层的最短路径值
# memo 中 key 为二元组 （x，y）
# memo 中 value 为从x，y走到最底层的最短路径值 
def divide_conquer(self, triangle, x, y):
    if x == len(triangle):
        rturn 0
    
    # 如果找过了，就不要再找了，直接把之前找到的值返回
    if (x, y) in memo:
        return memo[(x, y)]

    left = self.divide_conquer(self, triangle, x + 1, y)
    right = self.divide_conquer(self, triangle, x + 1, y + 1)

    # 在 return 之前先把这次找到的最短路径值记录下来
    # 避免之后重复搜索
    memo[(x, y)] = min(left, right) + triangle[x][y]
    return memo[(x,y)]

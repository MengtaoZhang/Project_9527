'''
使用交换调整策略的随机化算法
'''
'''
最优化剪枝-python版本
tips：DFS尿性就是参数贼多，开始写没弄全很正常，发现了的话后面加上去就好
'''

RANDOM_TIMES = 2000

# 以下都在 class Solution中
def minCost(self, n, roads):
    graph = self.construct_graph(roads, n)
    min_cost = float('inf')
    for _ in range(RANDOM_TIMES):
        path = self.get_random_path(n)
        cost = self.adjust_path(path, graph)
        min_cost = min(min_cost,cost)
    return min_cost
    
def construct_graph(self, roads, n):
    graph = {
        i: {j: float('inf') for j in range(1, n + 1)}
        for i in range(1, n + 1)
    }
    for a, b, c in roads:
        graph[a][b] = min(graph[a][b], c)
        graph[b][a] = min(graph[b][a], c)
    return graph

def get_random_path(self, n):
    import random

    path = [i for i in range(1, n + 1)]
    for i in range(2, n):
        j = random.randint(1, i)
        path[i], path[j] = path[j], path[i]
    return path

def adjust_path(self, path, graph):
    n = len(graph)
    adjusted = True
    while adjusted:
        adjusted = False
        for i in range(1, n):
            for j in range(i + 1, n):
                if self.can_swap(path, i, j, graph):
                    path[i], path[j] = path[j], path[i]
                    adjusted = True
    
    cost = 0
    for i in range(1, n):
        cost += graph[path[i - 1]][path[i]]
    return cost

def can_swap(self, path, i, j, graph):
    before = self.adjcent_cost(path, i, path[i], graph)
    before += self.adjcent_cost(path, j, path[j], graph)
    after = self.adjcent_cost(path, i, path[j], graph)
    after += self.adjcent_cost(path, j, path[i], graph)
    return before > after

def adjcent_cost(self, path, i, city, graph):
    cost = graph[path[i - 1]][city]
    if i + 1 < len(path):
        cost += graph[city][path[i + 1]]
    return cost
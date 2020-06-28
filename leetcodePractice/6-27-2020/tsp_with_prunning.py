'''
最优化剪枝-python版本
tips：DFS尿性就是参数贼多，开始写没弄全很正常，发现了的话后面加上去就好
'''

class Result:
    def __init__(self):
        self.min_cost = float('inf')

# 以下都在 class Solution中
def minCost(self, n, roads):
    graph = self.construct_graph(roads, n)
    result = Result()
    self.dfs(1, n, [1], set([1]), 0, graph, result)
    return result.min_cost

def dfs(self, city, n, path, visited, cost, graph, result):
    if len(visited) == n:
        result.min_cost = min(result.min_cost, cost)
        return 
    
    for next_city in graph[city]:
        if next_city in visited:
            continue
        if self.has_better_path(graph, path, next_city):
            continue
        visited.add(next_city)
        path.append(next_city)
        self.dfs(
            next_city,
            n,
            path,
            visited,
            cost + graph[city][next_city],
            graph,
            result
        )
        path.pop()
        visited.remove(next_city)

def construct_graph(self, roads, n):
    graph = {
        i: {j: float('inf') for j in range(1, n + 1)}
        for i in range(1, n + 1)
    }
    for a, b, c in roads:
        graph[a][b] = min(graph[a][b], c)
        graph[b][a] = min(graph[b][a], c)
    return graph

# 如果感觉这个函数不好懂，就看下ipad里面的笔记，或者自己画个图
def has_better_path(self, graph, path, city):
    for i in range(1, len(path)):
        if graph[path[i - 1]][path[i]] + graph[path[-1]][city] >\
            graph[path[i - 1]][path[-1]] + graph[path[i]][city]:
            return True
        
    return False

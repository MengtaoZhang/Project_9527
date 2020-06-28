'''
全排列
'''

def permute(self, nums):
    if not nums:
        # 0!= 1
        return [[]]

    permutations = []
    self.dfs(nums, set(), [], permutations)
    return permutations

# 递归的定义： 找到所有 permutation 开头的permutations
def dfs(self, nums, visited, permutation, permutations):
    # 递归的出口
    if len(nums) == len(permutation):
        permutations.append(list(permutation))
        return
    
    # 递归的拆解
    # [] -> [1], [2], [3]
    # [1] -> [1,2], [1,3], [1,4]
    for num in nums:
        if num in visited:
            continue
        permutation.append(num)
        visited.add(num)
        self.dfs(nums, visited, permutation, permutations)
        visited.remove(num)
        permutation.pop()
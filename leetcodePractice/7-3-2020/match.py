'''
通配符匹配
lintcode-192
'''

def isMatch(self, source, pattern):
    return self.is_match_helper(source, 0, pattern, 0, {})

def is_match_helper(self, source, i, pattern, j, memo):
    if (i, j) in memo:
        return memo[(i, j)]
    
    # 递归的出口
    # source is empty
    if len(source) == i:
        # every char should be "*"
        return self.is_all_star(pattern, j)
    if len(pattern) == j:
        return False

    # 递归的拆解
    if pattern[j] != "*":
        matched = self.is_match_char(source[i], pattern[i]) and \
            self.is_match_helper(source, i + 1, pattern, j + 1, memo)
    else:
        matched = self.is_match_helper(source, i + 1, pattern, j, memo) or \
            self.is_match_helper(source, i, pattern, j + 1, memo)
    
    memo[(i, j)] = matched
    return matched

def is_match_char(self, s, p):
    return s == p or p == "?"
    

    #
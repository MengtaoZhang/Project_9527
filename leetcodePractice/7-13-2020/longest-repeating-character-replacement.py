'''
k 次替换后的最长重复字符字串
'''

def characterReplacement(s, k):
    if not s:
        return 0

    # j 指向满足条件的子字符串的后面一个位置
    j = 0
    maxFreq = 0
    counter = {}
    answer = 0
    for i in range(len(s)):  # O(n)
        while j < len(s) and j - i - maxFreq <= k:  # Q(n)
            counter[s[j]] = counter.get(s[j], 0) + 1
            maxFreq = max(maxFreq, counter[s[j]])
            j += 1
        
        if j - i - maxFreq > k:
            # i ~ j - 1 的 substring 需要 k + 1 次替换
            # i ~ j - 2 的 substring 需要 k  次替换
            answer = max(answer, j - i - 1)
        else:
            # i ~ j - 1 的 substring <= k 次替换 
            answer = max(answer, j - 1)
        
        counter[s[j]] -= 1
        maxFreq = max(counter.values())
    
    return answer
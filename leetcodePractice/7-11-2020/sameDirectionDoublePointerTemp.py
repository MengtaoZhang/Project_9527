'''
同向双指针的模版
'''

j = 1
for i from 0 to n - 1:
    while j < n and i, j的搭配不满足条件:
        j += 1
    if j >= n:
        break
    处理 i，j 的这次搭配
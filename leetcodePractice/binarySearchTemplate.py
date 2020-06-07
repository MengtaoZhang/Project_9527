'''
This is a template of binary search.
'''

def binarySearchTemplate(nums, target):
    if not nums:
        return -1

    start, end = 0, len(nums) - 1
    # 用start + 1 < end而不是start < end目的是为了避免死循环
    # 在first position of target 的情况下不会出现死循环
    # 但是在last position of target情况下会出现死循环
    # 样例： nums = [1,1] target = 1

    while start + 1 < end:
        mid = (start + end) // 2
    
        # >, =, <的逻辑先分开写，然后再看看=的情况是否能合并到其他分支里
        if nums[mid] <  target:
            start = mid
        elif nums[mid] == target:
            end = mid
        else:
            end = mid

    if nums[start] == target:
        return start
    if nums[end] == target:
        return end
    
    return -1

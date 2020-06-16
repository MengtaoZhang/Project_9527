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

    while start + 1 < end: #避免在lastPosition这种问题中会出现的死循环
        mid = (start + end) // 2 # mid = start + (end - start) / 2 这样写可以避免正数过大而导致的overflow
    
        # >, =, <的逻辑先分开写，然后再看看=的情况是否能合并到其他分支里
        if nums[mid] <  target:
            start = mid
        elif nums[mid] == target:
            end = mid
        else:
            end = mid

    # 由于如果nums是两个数时会直接退出循环，需要在这里分别判断start和end的值是否是target
    if nums[start] == target:
        return start
    if nums[end] == target:
        return end
    
    return -1

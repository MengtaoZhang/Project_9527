'''
Use recursion to write a binary search.
'''

def binarySearch(nums, target):
    if nums is None:
        return -1
    
    return binarySearch(nums, 0, len(nums) - 1, target)

def binarySearch(nums, start, end, target):
    middle = int((start + end) / 2)
    
    if nums[middle] == target:
        return middle
    elif nums[middle] < target:
        return binarySearch(nums, middle + 1, end, target)
    else:
        return binarySearch(nums, start, middle, target)


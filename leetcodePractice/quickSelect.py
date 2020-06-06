'''
This algothrim is for finding k-th largest(smmalest) number.
'''

def kthLargestElement(k, nums):
    if nums is None:
        return -1

    return quickSelect(nums, 0, len(nums) - 1, k)

def quickSelect(nums, start, end, k):
    if start == end:
        return nums[start]
  
    i, j = start, end
    pivot = nums[(i + j) / 2]

    while i <= j:
        while i <= j and nums[i] > pivot:
            i += 1
        while i <= j and nums[j] > pivot:
            j -= 1
        if i <= j:
            nums[i], nums[j] = nums[j], nums[i]
        i += 1
        j -= 1

    if start + k - 1 <= j:
        return quickSelect(nums, start, j, k)
    if start + k - 1 >= i:
        return quickSelect(nums, i, end, k - (i - start))
    
    return nums[j + 1]

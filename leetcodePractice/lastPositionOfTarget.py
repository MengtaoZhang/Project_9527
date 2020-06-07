'''
Use binary search to find the last position of target.
'''

def lastPosition(nums, target):
    if nums is None:
	return -1

    start, end = 0, len(nums) - 1
    while start + 1 < end:
        mid = int((start + end) / 2)
	if nums[mid] == target:
	    start = mid
	elif nums[mid] < target:
	    start = mid + 1
	else:
	    end = mid - 1

    #在这个问题下我们找的是最后的位置，如果找第一个位置的话，则只需将两个if调换位置
    if nums[end] == target:
	return end
    if nums[start] == target:
	return start
    
    return -1

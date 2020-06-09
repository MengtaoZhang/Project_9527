'''
j - i = target
j = target + i
That's why there is target + nums[i] in 13th line.
'''

def twoSum7(nums, target):
	if not nums:
		return [-1, -1]
	
	target = abs(target)
	for i in range(len(nums)):
		j = binary_search(nums, i + 1, len(nums) - 1, target + nums[i])
		if j != -1:
			return [nums[i], nums[j]]

def binary_search(nums, start, end, target):
	while start + 1 < end:
		mid = (start + end) // 2
		if nums[mid] < target:
			start = mid
		else:
			end = mid
	if nums[start] == target:
		return start
	if nums[end] == target:
		return end

	return -1




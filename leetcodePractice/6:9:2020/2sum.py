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


# Improved one using double pointer with same direction 同向双指针
def twoSun7(nums, target):
	if nums is None or len(nums) < 2:
		return [-1, -1]

	target = abs(target)

	'''
	[2, 7, 9, 14]  target = 7
	 ^  ^
	 i  j

	 对于每个i， 找到第一个j， 使得nums[j] - nums[i] >= target
	'''

	int j = 1
	for i in range(len(nums)):
		j = max(j, i + 1) # 防止i的位置超过j
		while j < len(nums) and nums[j] - nums[i] < target)"
			j += 1
		if j >= len(nums):
			break
		if num[j] - nums[i] == target:
			return [nums[i], nums[j]]
	
	return [-1, -1]

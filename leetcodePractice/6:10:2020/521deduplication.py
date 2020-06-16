'''
j 代表最后一个唯一的数 last unique number
i 代表当前最后一个unipuq number是啥
'''

def deduplication(nums):
	if not nums:
		return 0

	nums.sort()
	j = 1
	for i in range(len(nums)):
		while j < len(nums) and nums[j] == nums[i]:
			j += 1
		if j >= len(nums):
			break
		nums[i + 1] = nums[j]
	
	return i + 1



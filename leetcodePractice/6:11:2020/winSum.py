def winSum(nums, k):
	if not nums or len(nums) < k:
		return []

	result = []
	j, window_sum = 0, 0
	for i in range(len(nums)):
		while j < len(nums) and j - i < k:
			window_sum += nums[j]
			j += 1
		if j - i == k:
			result.append(window_sum)
		window_sum -= num[i]
	
	return result

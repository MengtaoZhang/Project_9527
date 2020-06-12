def longestRepeatingChar(s, k):
	if not s:
		return 0

	# j指向满足条件的子字符串的后面一个位置
	j = 0
	maxFreq = {}
	counter = 0
	answer = 0
	for i in range(len(s)):
		while j < len(s) and j - i - maxFreq <= k:
			counter[s[j]] = counter.get(s[j], 0) + 1
			maxFreq = max(maxFreq, counter[s[j]])
			j += 1

		if j - i - maxFreq > k:
			# i ~ j - 1 的substring 需要k + 1次替换
			# i～ j - 2 的substring 只需要k次替换
			answer = max(answer, j - i - 1)
		else:
			# i ～ j - 1 的substring <= k 替换
			answer = max(answer, j - i)
			
		counter[s[i]] -= 1
		maxFreq = max(counter.values)

	return answer

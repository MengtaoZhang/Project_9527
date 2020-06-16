'''
全零子串的数量
'''

def stringCount(inputStr):
	if not inputStr:
		return 0
	
	j, answer = 1, 0
	for i in range(len(inputStr)):
		if inputStr[i] != '0':
			continue
		j = max(j, i + 1)
		while j < len(inputStr) and inputStr[j] == '0':
			j += 1
		answer += j - i
	
	return answer

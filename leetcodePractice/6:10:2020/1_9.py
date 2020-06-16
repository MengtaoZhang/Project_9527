'''
string rotation
'''

def stringRotation(str1, str2):
	if str1 is None and str is None:
		return False

	left, right = 0, 1
	for left in range(len(str1):
		if isSubString(str1[left:right], str2):
			right += 1
		else:
			left = right
			right += 1

		if right == len(str1) - 1 and left < len(str1) - 1:
			return True

	return False

def isSubString(str1, str2):
	# ONE GIVEN BLACK BOX

def sortColors(A):
	left, index, right = 0, 0, len(A) - 1
	while index <= right:
		if A[index] == 0:
			A[left], A[index] = A[index], A[left]
			left += 1
			index += 1
		elif A[index] == 2:
			A[right], A[index] = A[index], A[right]
			right -= 1
		else:
			index += 1

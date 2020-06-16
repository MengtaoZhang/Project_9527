def rerange(A):
	pos = len([a for a in A if a > 0])
	neg = len(A) - pos

	partition(A, pos > neg)
	interleave(A, pos == neg)

def partition(A, start_positive):
	flag = 1 if start_positive else -1
	left, right = 0, len(A) - 1
	while left <= right:
		while left <= right and A[left] * flag > 0:
			left += 1
		while left <= right and A[right] * flag < 0:
			right -= 1
		if left <= right:
			A[left], A[right] = A[right], A[left]
			left += 1
			right -= 1

def interleave(A, has_same_length):
	left, right = 1, len(A) - 1
	if has_same_length:
		right = len(A) - 2

	while left < right:
		A[left], A[right] = A[right], A[left]
		left, right = left + 2, right - 2


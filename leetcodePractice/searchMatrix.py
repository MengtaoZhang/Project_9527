def searchMatrix(matrix, target):
	if not matrix or not matrix[0]:
		return False
	
	n, m = len(matrix), len(matrix[0])
	start, end = 0, n * m - 1
	while start + 1 < end:
		mid = (start + end) // 2
		if get(matrix, mid) < target:
			start = mid
		else:
			end = mid

	if get(matrix, start) == target:
		return True
	if get(matrix, end) == target:
		return True
	return False

def get(matrix, index):
	x = index // len(matrix[0])
	y = index % len(matrix[0])
	return matrix[x][y]

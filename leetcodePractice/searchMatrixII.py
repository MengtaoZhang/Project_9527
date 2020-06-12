def searchMatrix(matrix, target):
	if not matrix or not matrix[0]:
		return 0
	
	n, m = len(matrix), len(matrix[0])
	x, y = n - 1, 0
	count = 0
	while x >= 0 and y < m:
		if matrix[x][y] == target:
			x -= 1
			y += 1
			count += 1
		elif matrix[x][y] > target:
			x -= 1
		else:
			y += 1

	return count

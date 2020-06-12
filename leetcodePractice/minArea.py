def minArea(image, x, y):
	if not image or not image[0]:
		return 0
	
	n, m = len(image), len(image[0])
	left = find_first(image, 0, y, check_column)
	right = find_last(image, y, m - 1, check_column)
	up = fins_first(image, 0, x, check_row)
	down = find_last(image, x, n - 1, check_row)
	
	return (right - left + 1) * (down - up + 1)

def check_column(image, col):
	for i in range(len(image)):
		if image[i][col] == '1':
			return True
	return False

def check_row(image, row):
	for j in range(len(image[0])):
		if image[row][j] == '1':
			return True
	return False

def find_first(image, start, end, check_func):
	while start + 1 < end:
		mid = (start + end) // 2
		if check_func(image, mid):
			end = mid
		else:
			start = mid
	
	if check_func(image, start):
		return start
	return end

def find_last(image, start, end, check_func):
	while start + 1 < end:
		mid = (start + end) // 2
		if check_func(image, mid):
			start = mid
		else:
			end = mid
	if check_func(image, end):
		return end
	return start



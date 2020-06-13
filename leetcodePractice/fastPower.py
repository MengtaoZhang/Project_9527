def fastPower(a, b, n):
	if n == 0:
		return 1 % b
	
	product = fastPower(a, b, n // 2)
	product = (product * product) * b
	if n % 2 == 1:
		product = (product * a) % b

	return product

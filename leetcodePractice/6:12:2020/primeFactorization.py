def primeFactorization(n):
	result = []
	up = int(math.sqrt(n))

	k = 2
	while k <= up and n > 1:
		while n % k == 0:
			n //= k
			result.append(k)
		k += 1
	
	if n > 1:
		result.append(n)
	
	return result

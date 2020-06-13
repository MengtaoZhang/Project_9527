def gcb(big, small):
	if small != 0:
		return gcb(small, big % small)
	else:
		return big

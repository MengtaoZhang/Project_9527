def copyBooks(pages, k):
	if pages is None and len(pages) == 0:
		return 0
	
	if k == 0:
		return -1

	start, end = 0, sum(pages)

	while start + 1 < end:
		mid = (start + end) // 2
		if getNumberOfCopiers(pages, mid) <= k:
			end = mid
		else:
			start = mid

	if getNumberOfCopiers(pages, start) <= k:
		return start
	
	return end

def getNumberOfCopiers(pages, limit):
	copiers = 0
	lastCopied = limit

	for page in pages:
		if page > limit:
			return sum(pages)
		if lastCopied + page > limit:
			copiers += 1
		    lastCopied = 0

		lastCopied += page
	
	return copiers

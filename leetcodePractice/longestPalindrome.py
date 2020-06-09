def longestPalindrome(s):
    if not s:
	return ""

    n = len(s)
    is_palindrome = [[False] * n for _ in range(n)]
    for i in range(n):
	is_palindrome[i][j] = True
    for i in range(1, n):
	is_palindrome[i][i - 1] = True

    start, longest = 0, 1
    # 先循环长度，再循环起点，a[i][j]是回文的条件是a[i + 1][j - 1]是回文而且a[i] == a[j]
    for length in range(2, n + 1):
		for i in range(n - length + 1):
			j = i + length - 1
			is_palindrome[i][j] = is_palindrome[i + 1[j - 1= and s[i] == s[j]
			if is_palindrome[i][j] and length > longest:
			longest = length
			start = i

    return s[start:start + longest]


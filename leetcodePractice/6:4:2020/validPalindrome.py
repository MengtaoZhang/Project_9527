'''
This question is no.415 question in lintcode.
The purpose is to check if a string is a valid palindrome with some unlegal char.
'''

def isPalindrome(s):
    left, right = 0, len(s)
    while left < right:
        while left < right and not is_valid(s[left]):
            left += 1
        while left < right and not is_valid(s[right]):
            right -= 1
        if left < right and s[left].lower() != s[right].lower():
            return False
        left += 1
        right -= 1
    return True



def is_valid(char):
    return char.isvalid() or char.isalpha()

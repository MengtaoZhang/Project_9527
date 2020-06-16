'''
This question is about a game. If the total num could diveded by 4, then you win. Because your oppisite could take 1, 2, 3 stones. When only 4 stones left, you will definately lose.
'''

def canWinNim(n: int) -> bool:
    if n < 4:
        return True
    if n % 4 == 0:
        return False
    else:
        return True

'''
I just Wrate a stupid fabonacci code.
'''

def fibonacci(n):
    if n <= 2:
        return n - 1
    
    fiboList = [0, 1]
    result = 0
    for i in range(2, n):
        temp = fiboList[i - 1] + fiboList[i - 2]
        fiboList.append(temp)
    result = fiboList[-1]

    return result

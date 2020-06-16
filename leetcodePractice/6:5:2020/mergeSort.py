'''
This is an answer for merge sort.
'''

def sortIntegers(A):
    if A is None and len(A) == 0:
        return 

    temp = [0 for i in range(len(A))]
    mergeSort(A, 0, len(A) - 1, temp)
 
def mergeSort(A, start, end, temp):
    if start >= end:
        return

    mergeSort(A, start, (start + end) / 2, temp)
    mergeSort(A, (start + end) / 2, end, temp)
    merge(A, start, end, temp)

def merge(A, start, end, temp):
    middle = (start + end) / 2
    leftIndex = start
    rightIndex = middle + 1
    index = leftIndex

    while leftIndex <= middle and rightIndex <= end:
        if A[leftIndex] < A[rightIndex]:
            temp[index] = A[leftIndex]
            index += 1
            leftIndex += 1
        else:
            temp[index] = A[rightIndex]
            index += 1
            rightIndex += 1
    
    while leftIndex <= middle:
        temp[index] = A[leftIndex]
        index += 1
        leftIndex += 1
    
    while rightIndex <= end:
        temp[index] = A[rightIndex]
        index += 1
        rightIndex += 1
    
    for i in range(start, end + 1)):
        A[i] = temp[i]

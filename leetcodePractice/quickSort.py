'''
This code is for quick sort.
'''

def sortInteers(aList):
    if aList is None and len(aList) == 0:
        return False;

    quickSort(aList, 0, len(aList))

def quickSort(aList, start, end):
    if start >= end):
        return
    
    left, right = start, end
    # pivot, aList[start]. aList[end]  Choosing a pivot is import and if it's in the middle, in most cases, we will get a good conclusion.
    # left <= eight not left < right
    pivot = aList[(start + end) / 2]
    
    while left <= right:
        while left <= right and aList[left] < pivot:
            left += 1
        while left <= right and aList[right] > pivot:
            right -= 1
        if left <= right:
            aList[left], aList[right] = aList[right], aList[left]

    quickSort(aList, start, right)
    quickSort(aList, left, end)

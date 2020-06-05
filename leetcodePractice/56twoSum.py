'''
Find two nums adding together equaling with target.
'''

def twoSum(numbers, target):
    '''
    @param numbers: An array of Integer
    @param target: target = numbers[index1] + numbers[index2]
    @return: [index1, index2](index1 < index2)
    
    hashset = set()
    for number in numbers:
        if target - number in hashset:
            return number, target - number
        hashset.add(number)
    return [-1, -1]

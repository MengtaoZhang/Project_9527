'''
Find two nums adding together equaling with target.
'''

def twoSum(numbers, target):
    '''
    @param numbers: An array of Integer
    @param target: target = numbers[index1] + numbers[index2]
    @return: [index1, index2](index1 < index2)
    
    # FOR THE QUESTION NOT NEEDING INDEX
    hashset = set()
    for number in numbers:
        if target - number in hashset:
            return number, target - number
        hashset.add(number)
    return [-1, -1]

# FOR THE QUESTION NEEDING INDEX
def twoSum(numbers, target):
    
    if numbers is None:
        return False
    
    target_dict = {}
    
    for i in range(len(numbers)):
        if target - numbers[i] in target_dict:
            return [target_dict[target - numbers[i]], i]
        taret_dict[numbers[i]] = i
    return False

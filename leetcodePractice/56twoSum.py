'''
Find two nums adding together equaling with target.

In the first two methods, it will cost O(n) in Time and Space Complexity
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


# Use sort and two pointer approach to solve.
'''
In this way, we will need O(nlog) Time Complexity and O(1) Space Complexity
'''
def twoSum(numbers, target):
    numbers.sort()

    left, right = 0, len(numbers) - 1
    while left < right:
        if numbers[left] + numbers[right] > target:
            right -= 1
        elif numbers[left] + numbers[right] < target:
            left += 1
        else:
            return numbers[left], numbers[right]
    
return [-1, -1]

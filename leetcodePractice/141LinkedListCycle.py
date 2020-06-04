'''
This is a function that check if one linked list has cycle.
Using fast slow pointer could check if there is. So brilliant.
'''

def hasCycle(head:listNode) -> bool:
    slowPointer = head
    fastPointer = head
    while True:
        try:
            slowPointer = slowPointer.next
            fastPointer = fastPointer.next.next
        except:
            return False
        if slowPointer == fastPointer:
            return True


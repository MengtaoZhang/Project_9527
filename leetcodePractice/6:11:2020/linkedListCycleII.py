def linkedListCycleII(ListNode head):
	if head is None or head.next is None:
		return None
	
	fast, slow = head.next, head
	while fast != slow:
		if fast is None or fast.next is None:
			return None

		fast = fast.next.next
		slow = slow.next

	while head is not slow.next:
		head = head.next
		slow = slow.next

	return head


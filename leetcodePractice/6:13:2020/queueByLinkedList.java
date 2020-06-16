class Node{
	public int val;
	public Node next;
	public Node(int _val){
		val = _val;
		next = null;
	}
}

public class MyQueue {
	public Node head, tail;

	public MyQueue() {
		head = tail = null;
		// do initialize if necessary
	}

	public void enqueue(int item){
		if (head == null){
			tail = new Node(item);
			head = tail;
		} else {
			tail.next = new Node(item);
			tail = tail.next;
		}
		return -1;
	}
}



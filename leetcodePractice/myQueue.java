// 这种实现方式会造成部分内存无法使用


public class MyQueue{
	public int head, tail;
	public int MAXSIZE = 100000;
	public int[] queue = new int[MAXSIZE];

	public MyQueue(){
		head = tail = 0;
		// do initialize if necessary
	}

	public void enqueue(int item){
		// queue is full
		if (tail == MAXSIZE){
			return ;
		}

		queue[tail++] = item;
	}

	public int dequeue(){
		// if queue is empty
		if (head == tail){
			return -1;
		}

		return queue[head++];
	}
}

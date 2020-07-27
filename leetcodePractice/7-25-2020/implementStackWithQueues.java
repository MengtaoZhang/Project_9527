public class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    private void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.pull());
        }
    }

    // Q2 is buffer. 保持 Q1 有数
    // 只是交换了内存地址
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * push a new item into the stack
     */
    public void push(int value) {
        queue1.offer(value);
    }

    /**
     * return the top of the stack
     */
    public int top() {
        int item = pop();
        queue1.offer(item);
        return item;
    }

    /**
     * pop the top of the stack and return it
     * 数据来回倒换会很多次(by moveItems()) --->> Should be O(n)
     */
    public int pop() {
        moveItems();
        int item = queu1.poll();
        swapQueues();
        return item;
    }

    /**
     * check the stack is empty or not
     */
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
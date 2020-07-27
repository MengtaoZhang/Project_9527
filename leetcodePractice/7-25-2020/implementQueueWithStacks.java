/**
 * 本题是要求用两个栈实现队列的功能
 * 
 * 平均时间复杂度来讲：push(), pop(), top() 都是 O(1)，因为每个元素最多进出栈一次
 * 
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}
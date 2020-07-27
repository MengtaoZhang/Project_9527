/**
 * 最小栈的代码实现
 */
public class MinStack {
    Stack<Integer> stack, MinStack;

    public MinStack() {
        stack = new stack<Integer>();
        minStack = new stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty() || number < minStack.peek()) {
            minStack.push(number);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // push可以做个优化，只push <= 当前最小值的元素
    // 并且pop() 也做了适当修改
    public void pushII (int number) {
        stack.push(number);
        if (minStack.empty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    // 优化过后的pop()
    public int popII() {
        int number = stack.pop();
        if (number == minStack.peek()) {
            minStack.pop();
        }
        return number;
    }

    public int min() {
        return minStack.peek();
    }
}
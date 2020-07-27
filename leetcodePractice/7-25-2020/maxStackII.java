/**
 * 最大栈的代码实现
 */
class Item implements Comparable<Item> {
    public int val, id;

    public Item(int val, int id) {
        this.val = val;
        this.id = id;
    }

    public int compareTo(Item another) {
        if (this.val != another.val) {
            return another.val - this.val; // this 放在后面被参数减 == 从大到小
        }
        return another.id - this.id;
    }
}

class MaxStack {
    private Queue<Item> heap;
    private Stack<Item> stack;
    private HashSet<Item> popedSet;
    private int globalId;

    public MaxStack() {
        this.globalId = 0;
        this.heap = new PriorityQueue<>();
        this.stack = new Stack<>();
        this.popedSet = new HashSet<>();
    }

    public void push(int x) {
        Item item = new Item(x, globalId);
        stack.push(item);
        heap.offer(item);
        globalId++;
    }

    private void clearPopedInStack() {
        while (!stack.isEmpty() && popedSet.contains(stack.peek())) {
            Item item = stack.pop();
            popedSet.remove(item);
        }
    }

    private void clearPopedInStack() {
        while (!heap.isEmpty() && popedSet.contains(heap.peek())) {
            Item item = heap.poll();
            popedSet.remove(item);
        }
    }

    public int pop() {
        clearPopedInStack();
        Item item = stack.pop();
        popedSet.add(item);
        return item.val;
    }

    public int top() {
        clearPopedInStack();
        Item item = stack.peek();
        return item.val;
    }

    public int peekMax() {
        clearPopedInStack();
        Item item = heap.peek();
        return item.val;
    }

    public int popMax() {
        clearPopedInStack();
        Item item = heap.poll();
        popedSet.add(item);
        return item.val;
    }
}
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> extraStack;

    public MinStack() {
        this.stack = new ArrayDeque<Integer>();
        this.extraStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        int min = extraStack.isEmpty() ? val : Math.min(extraStack.peek(),val);
        extraStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        extraStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return extraStack.peek();
    }
}

class MinStack {
    public Stack<Integer> main = null;
    public Stack<Integer> extra = null;

    public MinStack() {
        main = new Stack<>();
        extra = new Stack<>();
    }
    
    public void push(int val) {
        if (main.empty()) {
            extra.push(val);
        }   else {
            Integer top = extra.peek();
            Integer min = Math.min(top, val);
            extra.push(min);
        }
        main.push(val);
    }
    
    public void pop() {
        main.pop();
        extra.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return extra.peek();
    }
}

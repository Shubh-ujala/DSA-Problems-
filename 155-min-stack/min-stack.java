class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2; // min will store here
 
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int value) {
        if(!s1.isEmpty()){
            if(value <= s2.peek()){
                s2.push(value);
            }
            s1.push(value);
        }else{
            s1.push(value);
            s2.push(value);
        }
    }
    
    public void pop() {
        if(s1.peek().equals(s2.peek())){
            s2.pop();
        }
        s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
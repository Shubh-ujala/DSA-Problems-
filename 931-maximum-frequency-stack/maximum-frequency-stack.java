class FreqStack {
    HashMap<Integer,Integer> freq;
    HashMap<Integer,Stack<Integer>> freqStack;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }
    
    public void push(int val) {

        freq.put(val, freq.getOrDefault(val,0)+1);
        int value = freq.get(val);
        maxFreq = Math.max(maxFreq, value);

        if(!freqStack.containsKey(value)){
            Stack<Integer> st= new Stack<>();
            st.push(val);
            freqStack.put(value,st); 
        }else{
            Stack<Integer> temp = freqStack.get(value);
            temp.push(val);
        }

    }
    
    public int pop() {
        
        Stack<Integer> st = freqStack.get(maxFreq);

        int ele = st.pop();

        freq.put(ele, freq.get(ele) - 1);

        if (st.isEmpty()) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }

        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
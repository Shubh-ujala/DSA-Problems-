class Pair{
    int num;
    int span;
    Pair(int num, int span){
        this.num = num;
        this.span = span;
    }
}

class StockSpanner {
    Stack <Pair>st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int currSpan = 1;
        while(!st.isEmpty() && st.peek().num <= price){
            currSpan+= st.peek().span;
            st.pop();
        }
        st.push(new Pair(price,currSpan));
        return currSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
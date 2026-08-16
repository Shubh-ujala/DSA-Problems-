class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i>= 0 ;i--){
            while(!st.isEmpty() && st.peek() > prices[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }

            st.push(prices[i]);
        }

        for(int i = 0 ; i<n ; i++){
            if(res[i] == -1){
                res[i] = prices[i];
            }else{
                 res[i] = prices[i] - res[i];
            }
        }

        return res;
    }
}
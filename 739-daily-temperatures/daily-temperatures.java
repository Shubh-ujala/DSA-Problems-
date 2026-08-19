class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        for(int i = n -1  ; i >= 0 ; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                res[i] = st.peek() - i;
            }else{
                res[i] = 0;
            }
            st.push(i);
        }

        return res;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = NSE(heights);
        int[] pse = PSE(heights);

        int maxArea = Integer.MIN_VALUE;

        for(int i = 0 ; i<n ; i++){
            int width = nse[i] - pse[i] - 1;
            maxArea = Math.max(maxArea,heights[i]*width);
        }
        return maxArea;
    }
    public int[] NSE(int[] heights){
        int n = heights.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n - 1;  i >= 0 ; i--){
            while(!st.isEmpty()  && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n;
            }else{
                res[i] = st.peek();
            }

            st.push(i);
        }
        return res;
    }
    public int[] PSE(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];
        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = -1; 
            }else{
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i<heights.length ; i++){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                int ele = st.pop();

                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea,heights[ele] * (nse - pse - 1));
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int element= st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }
}
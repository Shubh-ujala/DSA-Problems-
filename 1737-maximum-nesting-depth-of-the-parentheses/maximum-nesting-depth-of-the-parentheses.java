class Solution {
    public int maxDepth(String s) {
        int maxLen = Integer.MIN_VALUE;
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                maxLen = Math.max(maxLen,st.size());
                st.pop();
            } 
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen; 
    }
}
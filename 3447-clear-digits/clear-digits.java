class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && Character.isDigit(ch))st.pop();
            else st.push(ch);
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb =  new StringBuilder();
        Stack<Character> st = new Stack<>();
        int idx = -1;

        for(int i = 0 ;i<word.length() ; i++){
            if(word.charAt(i) == ch){
                st.push(word.charAt(i));
                idx = i;
                break;
            }
            st.push(word.charAt(i));
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        if(idx != word.length() && idx != -1){
            for(int i = idx+1 ; i<word.length() ; i++){
                sb.append(word.charAt(i));
            }
        }

        return idx == -1 ? sb.reverse().toString() : sb.toString();
    }
}
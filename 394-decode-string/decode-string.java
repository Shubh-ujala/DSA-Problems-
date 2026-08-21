class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }else if(ch == '['){
                st.push(num);
                num = 0;
                st1.push(sb);
                sb = new StringBuilder();
            }else if(ch == ']'){
                int k =st.pop();
                StringBuilder temp = sb;
                sb = st1.pop();
                while(k-- > 0){
                    sb.append(temp);
                }
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
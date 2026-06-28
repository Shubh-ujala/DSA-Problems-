class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st  = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for(int i= 0 ; i<n ; i++){
            if( s.charAt(i) == ' '){
                continue;
            }
            else if(s.charAt(i) == '+'){
                // number ban gya
                // means add in result
                result += (number*sign);
                number = 0;
                sign = 1;
            }else if(s.charAt(i) == '-'){
                // number ban gya
                // means add in result
                result += (number*sign);
                number = 0;
                sign = -1;
            }else if(s.charAt(i) == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            }else if(s.charAt(i) == ')'){
                result += (number*sign); // bracket's result
                number = 0;
                int stack_sign = st.peek();
                st.pop();
                int last_result = st.peek();
                st.pop();

                result*= stack_sign;
                result+=last_result;

            }else{
                //s.charAt(i) == digit

                number = number*10 + (s.charAt(i) - '0');
            }
        }
        result+= (number*sign);
        return result;
    }
}
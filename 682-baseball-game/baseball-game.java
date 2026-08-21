class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String s : operations){
            if(s.equals("+")){
                int a = st.pop();
                int b = st.peek();
                int sum = a+ b;

                st.push(a);
                st.push(sum);
            }else if(s.equals("D")){
                int a = st.peek();
                st.push(2*a);
            }else if(s.equals("C")){
                st.pop();
            }else{
                // only digits are left
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while(!st.isEmpty()) sum+=st.pop();

        return sum;
    }
}
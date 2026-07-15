class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty())s1.pop();
            }else{
                s1.push(ch);
            }
        }
        for(char ch: t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty())s2.pop();
            }else{
                s2.push(ch);
            }
        }

        // StringBuilder st1 = new StringBuilder();
        // StringBuilder st2 = new StringBuilder();
        // while(!s1.isEmpty()){
        //     st1.append(s1.pop());
        // }
        // while(!s2.isEmpty()){
        //     st2.append(s2.pop());
        // }
        // return st1.toString().equals(st2.toString());

        return s1.equals(s2);
    }
}
class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String[] s = path.split("/");
        for(String str : s){
            if(str.equals("") || str.equals("."))continue;
            else if(str.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(str);
            } 
        }

        for(String str : st){
            sb.append("/").append(str);
        }

        if(st.isEmpty()){
            sb.append("/");
        }

        return sb.toString();
    }
}
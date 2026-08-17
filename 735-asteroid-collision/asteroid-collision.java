class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i =  0 ; i<asteroids.length ; i++){
            while(!st.isEmpty() && st.peek() >0 && asteroids[i]<0 && Math.abs(asteroids[i]) > st.peek()){
                st.pop();
            }
            if(!st.isEmpty() && asteroids[i]<0 && st.peek() >0 && Math.abs(asteroids[i]) < st.peek()){
                continue;
            }else if(!st.isEmpty() && asteroids[i]<0 && st.peek() >0 && Math.abs(asteroids[i]) == st.peek()){
                st.pop();
            }
            else{
                st.push(asteroids[i]);
            }
        }
        int k = st.size();
        int[]res = new int[k];
        int idx = 0;
        while(!st.isEmpty()){
            res[idx++] = st.pop();
        }

        reverse(res);
        return res;
    }
    private void reverse(int[] res){
        int i =0;
        int j = res.length - 1;
        while(i < j ){
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
    }
}
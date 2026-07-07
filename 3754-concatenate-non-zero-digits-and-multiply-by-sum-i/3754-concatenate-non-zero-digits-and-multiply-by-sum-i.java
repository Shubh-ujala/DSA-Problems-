class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) return 0;
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        while(n>0){
            long p = n%10;
            if(p!=0) sb.append(p);
            sum+= p;
            n = n/10;
        } 
        long ans = Long.parseLong(sb.reverse().toString());
        return ans*sum;    
    }
}
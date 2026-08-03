class Solution {
    int[] dp = new int[50001];
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int i = 0;
        int result = Integer.MIN_VALUE;

        Arrays.fill(dp,-1);
        int diff = solve(i,n,result,stoneValue);

        if(diff > 0) return "Alice";
        else if( diff == 0) return "Tie";

        return "Bob";
    }

    public int solve(int i , int n,int res, int[] stones){
        if( i >= n) return 0;
        if(dp[i]!= -1) return dp[i];

        res = Math.max(res,stones[i] - solve(i+1,n,res,stones));
        if(i+1 < n){
            res = Math.max(res,stones[i] + stones[i+1] - solve(i+2,n,res,stones));
        }
        
        if(i+2 < n){
            res = Math.max(res,stones[i] + stones[i+1] + stones[i+2] - solve(i+3,n,res,stones));
        }
        return dp[i] = res;
                
    }
}
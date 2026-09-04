class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(0,1,prices,dp);
    }
    public int solve(int idx , int canBuy , int[] prices,int[][]dp){

        if(idx == prices.length) return 0;
        if(dp[idx][canBuy] != -1) return dp[idx][canBuy];

        int profit = Integer.MIN_VALUE;
        if(canBuy == 1){
            profit = Math.max((-prices[idx] + solve(idx+1,0,prices,dp)),(0 + solve(idx+1,1,prices,dp)));
        }else{
            profit = Math.max((prices[idx] + solve(idx+1,1,prices,dp)),(0 + solve(idx+1,0,prices,dp)));
        }

        return dp[idx][canBuy] = profit;
    }
}
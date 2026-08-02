class Solution {
    int[][] dp = new int[501][501];
    public boolean stoneGame(int[] piles) {
        int i = 0;
        int j = piles.length - 1;

        for(int d[]:dp){
            Arrays.fill(d,-1);
        }

        int totalScore = 0;
        for(int k : piles) totalScore+=k;
        int AliceScore = solve(i,j,piles);
        int bobScore = totalScore - AliceScore;
        return AliceScore > bobScore;
    }

    public int solve(int i , int j,int[] piles ){

        if(i>j) return 0;
        if(i == j) return piles[i];

        if(dp[i][j]!= -1) return dp[i][j];

        
        int alice_t = piles[i] + Math.min(solve(i+2,j,piles),solve(i+1,j-1,piles));
        int bob_t = piles[j] + Math.min(solve(i+1,j-1,piles),solve(i,j-2,piles));

        return dp[i][j] = Math.max(alice_t,bob_t);
    }
}
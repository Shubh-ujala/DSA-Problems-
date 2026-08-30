class Solution {
    int[][] dp = new int[101][101];
    public int uniquePaths(int m, int n) {
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1);
    }
    public int solve(int i , int j){

        if(i == 0 && j == 0) return 1;
        if(i <0 || j < 0) return 0;
        if(dp[i][j]!= -1) return dp[i][j];

        int up = solve(i-1,j);
        int left = solve(i,j-1);
        return dp[i][j] = up+left;
    }
}
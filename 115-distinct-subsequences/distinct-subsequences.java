class Solution {
    int[][] dp = new int[1001][1001];
    public int numDistinct(String s, String t) {
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,s,t);
    }

    public int solve(int i , int j, String s , String t){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j]!= -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] =  solve(i+1,j+1, s, t) + solve(i+1,j,s,t);
        }else{
            return dp[i][j] = solve(i+1,j,s,t);
        }
    }
}
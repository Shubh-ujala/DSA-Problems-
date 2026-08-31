class Solution {
    int[][] dp = new int[101][101];
    public int minFallingPathSum(int[][] matrix) {
        for(int[]row: dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int min = Integer.MAX_VALUE;

        for(int j = 0 ; j< n ; j++){
            int temp = solve(m - 1,j,n,matrix);
            min = Math.min(min,temp);
        }

        return min;
    }
    public int solve(int i , int j , int n , int matrix[][]){

        if( j < 0 || j >= n) return (int)1e9;
        if(dp[i][j]!= Integer.MAX_VALUE) return dp[i][j];

        if (i == 0) {
            return dp[i][j] = matrix[i][j];
        }

        int up = matrix[i][j] + solve(i - 1 , j , n , matrix);
        int ld = matrix[i][j] + solve(i - 1, j - 1, n , matrix);
        int rd = matrix[i][j] + solve(i - 1 , j + 1, n,matrix);

        return dp[i][j] = Math.min(up,Math.min(ld,rd));
    }
}
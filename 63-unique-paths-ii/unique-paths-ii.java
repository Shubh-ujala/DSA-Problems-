class Solution {
    int[][] dp = new int[101][101];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for(int row[] : dp)Arrays.fill(row,-1);
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return solve(m - 1, n - 1,obstacleGrid);
    }

    public int solve(int i , int j , int[][] matrix){

        if( i < 0 || j < 0) return 0;

        if( matrix[i][j] == 1) return 0;

        if( i == 0 && j == 0) return 1;

        if( dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = solve(i - 1,j,matrix) + solve( i , j - 1 , matrix);
    }
}
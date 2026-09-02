class Solution {
    int[][][] dp = new int[71][71][71];
    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return solve( 0 , 0 , m- 1 , grid);

    }
    public int solve(int i1 , int j1, int j2 , int[][]grid){

        if( j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) {
            return (int)(-1e9);
        }

        if(dp[i1][j1][j2]!= -1) return dp[i1][j1][j2];

        if(i1 == grid.length - 1){
            if(j1 == j2){
                return grid[i1][j1];
            }else{
                return grid[i1][j1] + grid[i1][j2];
            }
        }

        int max = Integer.MIN_VALUE;

        for(int dj1 = -1 ; dj1 <=1 ; dj1++){
            int ans;
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                if( j1 == j2){
                    ans = grid[i1][j1] + solve(i1+1,j1+dj1,j2+dj2,grid);
                }else{
                    ans = grid[i1][j1] + grid[i1][j2] + solve(i1+1,j1+dj1,j2+dj2,grid);
                }
                max = Math.max(max,ans);
            }
        }
        return dp[i1][j1][j2] =  max;
    }
}
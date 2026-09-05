class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        int count = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(i,j,visited,grid);
                }
            }
        }

        return count;
    }

    private void dfs(int row , int col , boolean[][] visited,char[][] grid){

        visited[row][col] = true;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i = 0 ; i < 4 ; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == '1'){
                dfs(nr,nc,visited,grid);
            }
        }
    }
}
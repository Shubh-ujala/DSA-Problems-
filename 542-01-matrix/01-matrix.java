class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        bfs(visited,q,mat);

        return mat;
    }
    private void bfs( boolean[][] visited, Queue<int[]> q, int[][] mat){

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int currRow = curr[0];
            int currCol = curr[1];

            for(int i = 0 ; i<4 ; i++){
                int nr = currRow + dr[i];
                int nc = currCol + dc[i];

                if(nr >=0 && nr < mat.length && nc >= 0 && nc < mat[0].length && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    mat[nr][nc] = mat[currRow][currCol] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
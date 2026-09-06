class Solution {
    public char[][] solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i<n ; i++){
            if(mat[i][0] == 'O'){
                visited[i][0] = true;
                q.offer(new int[]{i,0});
            }
            if(mat[i][m-1] == 'O'){
                visited[i][m-1] = true;
                q.offer(new int[]{i,m-1});
            }
        }
        for(int i = 0 ; i<m ; i++){
            if(mat[0][i] == 'O'){
                visited[0][i] = true;
                q.offer(new int[]{0,i});
            }
            if(mat[n-1][i] == 'O'){
                visited[n-1][i] = true;
                q.offer(new int[]{n-1,i});
            }
        }

        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int i = 0 ; i<4 ; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc>=0 && nc < m && !visited[nr][nc] && mat[nr][nc] == 'O'){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }   
            }
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(mat[i][j] == 'O' && !visited[i][j]){
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }
}
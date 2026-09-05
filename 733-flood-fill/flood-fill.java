class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean visited[][] = new boolean[n][m];
        int currColor = image[sr][sc];
        dfs(sr,sc,color,currColor,visited,image);

        return image;
    }
    public void dfs(int sr , int sc , int color ,int currColor, boolean[][] visited, int[][] image){

        visited[sr][sc] = true;
        image[sr][sc] = color;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i = 0 ; i<4 ; i++){
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nc >=0 && nr < image.length && nc <image[0].length && !visited[nr][nc] && image[nr][nc] ==currColor && image[nr][nc]!= color){
                dfs(nr,nc,color,currColor,visited,image);
            }
        }
    }
}
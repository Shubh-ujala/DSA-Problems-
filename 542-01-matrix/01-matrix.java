class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {

                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    !visited[nrow][ncol]) {

                    visited[nrow][ncol] = true;

                    dist[nrow][ncol] = dist[row][col] + 1;

                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        return dist;
    }
}
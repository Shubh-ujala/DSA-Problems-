class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ;j<m ; j++){
                if(grid[i][j] == 1) freshCount++;
                else if(grid[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        if(freshCount == 0) return 0;
        int time = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size; i++){
                int rottenLocation[] = q.poll();
                int r = rottenLocation[0];
                int c = rottenLocation[1];

                int neighbours[][] = {
                    {r-1,c},{r,c+1},{r+1,c},{r,c-1}
                };

                for(int nbr[] : neighbours){
                    int nr = nbr[0];
                    int nc = nbr[1];

                    // check if outof bound / already rotten(visited)

                    if(nr<0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 2 || grid[nr][nc] == 0) continue;

                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = 2;

                    freshCount --;
                    if(freshCount == 0) return time+1;
                }
            }

            time++;
        }
        return -1;
    }
}
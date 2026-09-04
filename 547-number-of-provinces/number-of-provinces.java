class Solution {

    public int findCircleNum(int[][] adj) {

        int n = adj.length;
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    public void dfs(int idx, int[][] adj, boolean[] visited) {

        visited[idx] = true;

        for(int j = 0 ; j<adj.length ; j++){
            if(adj[idx][j] == 1 && !visited[j]){
                dfs(j,adj,visited);
            }
        }
    }
}
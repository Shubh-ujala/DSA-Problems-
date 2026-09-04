class Solution {

    public int findCircleNum(int[][] adj) {

        int n = adj.length;
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                count++;
                bfs(i, adj, visited);
            }
        }

        return count;
    }

    public void bfs(int idx, int[][] adj, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int j = 0; j < adj.length; j++) {

                if (adj[curr][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}
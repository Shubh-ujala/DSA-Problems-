class Solution {
    private boolean bfs(int i , int[] color , List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        color[i] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nbr : adj.get(node)){
                if(color[nbr] == -1){
                    color[nbr] = 1 - color[node];   
                    q.offer(nbr);
                }else if(color[nbr] == color[node]) return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = getAdjListRepresentation(graph);
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i = 0 ; i<n ; i++){
            if(color[i] == -1){
                if(!bfs(i,color,adj)) return false;
            }
        }
        
        return true;
    }

    private List<List<Integer>> getAdjListRepresentation(int[][] graph){
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<n ; i++){
            int u = i;
            for(int j = 0 ; j<graph[i].length; j++){
                int v = graph[i][j];
                adj.get(u).add(v);
            }
        }

        return adj;
    }
}
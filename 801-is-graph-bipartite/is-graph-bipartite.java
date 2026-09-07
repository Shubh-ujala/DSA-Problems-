class Solution {
    private boolean dfs(int i ,int currColor, int[] color, List<List<Integer>> adj){
        color[i] = currColor;

        for(int nbr : adj.get(i)){
            if(color[nbr] == -1){
                if(!dfs(nbr,1-currColor,color,adj)) return false;
            }else if(color[nbr] == currColor) return false;
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
                if(!dfs(i,0,color,adj)) return false;
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
class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0 ; i< n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i<n ; i++){
            int u = i;
            for(int nbr : graph[i]){
                int v = nbr;
                adj.get(u).add(v);
            }
        }


        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i = 0 ; i< n ; i++){
            if(color[i] == -1){
                if(!dfs(i,0,color,adj)) return false;
            }
        }

        return true;
    }
    public boolean dfs(int node ,int currColor, int[] color, List<List<Integer>> adj){
        color[node] = currColor;

        for(int nbr : adj.get(node)){
            if(color[nbr] == -1){
                if(!dfs(nbr,1-currColor,color,adj)) return false;
            }else if(color[nbr] == color[node]){
                return false;
            }
        }

        return true;
    }
}
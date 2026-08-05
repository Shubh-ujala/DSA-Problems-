class Solution {
    boolean hasOutSideConnection = false;
    int[] mark;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        mark = new int[n];

        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<invocations.length ; i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            graph.get(u).add(v);
        }

        bfs(1,graph,k);

        for(int i = 0; i<n ; i++){
            if( i == k || mark[i] == 1) continue;
            bfs(2,graph,i);
        }

        for(int i = 0 ; i<n ; i++){
            if(!hasOutSideConnection && mark[i] == 1)continue;
            res.add(i);
        }
        return res;
    }

    public void bfs(int color,ArrayList<ArrayList<Integer>> graph, int src ){
        Queue<Integer> q= new LinkedList<>();
        q.offer(src);
        mark[src] = color;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nbr : graph.get(node)){
                if(mark[nbr] == 1 && color == 2){
                    hasOutSideConnection = true;
                    return;
                }

                if(mark[nbr]!= color){
                    mark[nbr] = color;
                    q.offer(nbr);
                }
            }
        }
    }
}
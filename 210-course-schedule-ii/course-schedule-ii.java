class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int i = 0 ; i<prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        return topoSort(numCourses,indegree,adj);
    }

    public int[] topoSort(int numCourses,int[]indegree,List<List<Integer>> adj ){
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        int idx = 0;

        for(int i = 0 ; i<indegree.length ; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            res[idx++] = node;

            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.offer(nbr);
            }
        }
        if(idx < numCourses) {
            return new int[0];
        }
        return res;   
    }
}
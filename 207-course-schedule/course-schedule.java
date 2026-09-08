class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0 ; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i<prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0 ; i<indegree.length ; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.offer(nbr);
            }
        }

        return count == numCourses;        
    }
}
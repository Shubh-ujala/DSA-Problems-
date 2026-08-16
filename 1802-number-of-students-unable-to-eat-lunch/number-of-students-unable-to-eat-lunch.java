class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q= new LinkedList<>();
        for(int student : students){
            q.offer(student);
        }

        int j = 0;
        int attempts = 0;

        while(!q.isEmpty() && j <sandwiches.length){
            if(q.peek() == sandwiches[j]){
                q.poll();
                j++;
                attempts = 0;
            }else{
                q.offer(q.poll());
                attempts++;
            }

            if(attempts == q.size())break;
        }

        return q.size();
    }
}
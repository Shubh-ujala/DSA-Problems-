class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b)-> Integer.compare(b[0],a[0]));

        Stack<Double> st = new Stack<>();

        for(int i =  0 ; i< n ; i++){
            int pos = cars[i][0];
            int vel = cars[i][1];

            double time_to_reach_distance = (double)(target - pos)/vel;
            while(st.isEmpty() || st.peek() < time_to_reach_distance) st.push(time_to_reach_distance);

        }

        return st.size();
    }
}
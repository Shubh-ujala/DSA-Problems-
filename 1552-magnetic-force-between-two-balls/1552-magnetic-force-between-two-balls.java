class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int start = 1;
        int end = position[n - 1] - position[0];
        int ans = 1;
        while(start<=end){
            int mid = start+ (end - start)/2;
            if(canPlace(position, m , mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
    public boolean canPlace(int[] position, int m, int mid){
        int balls = 1;
        int last = position[0];
        for(int i =  0 ; i<position.length; i++){
            if(position[i] - last>=mid){
                balls++;
                last = position[i];

                if(balls==m){
                    return true;
                }
            }
        }
        return false;
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if ( sum % 2 != 0) return false;

        int target = sum /2 ;
        int[][] dp = new int[n][target+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }

        return solve( n - 1 , target , nums , dp);
    }
    public boolean solve(int idx , int target , int[] nums , int[][] dp){

        if(target == 0) return true;
        if(dp[idx][target]!= -1) return dp[idx][target] == 0 ? false : true;
        if( idx == 0) return nums[0] == target;

        boolean not_pick = solve(idx-1, target, nums, dp);
        boolean pick = false;
        if(target >= nums[idx]){
            pick = solve(idx - 1, target - nums[idx] , nums , dp);
        }
        
        dp[idx][target] = not_pick || pick ? 1 : 0;
        return not_pick || pick;
    }
}
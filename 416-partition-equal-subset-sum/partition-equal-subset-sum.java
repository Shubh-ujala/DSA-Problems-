class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];

        return solve(n - 1, target, nums, dp);
    }

    public boolean solve(int idx , int target , int[] nums , boolean[][] dp){

        for(int i =  0 ; i< nums.length ; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i<nums.length ; i++){
            for(int j = 1 ; j <= target ; j++){
                boolean not_pick = dp[i-1][j];
                boolean pick = false;
                if(j >= nums[i]){
                    pick = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = not_pick || pick;
            }
        }

        return dp[nums.length - 1][target];
    }
}
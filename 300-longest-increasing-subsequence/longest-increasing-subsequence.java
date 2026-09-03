
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][]dp = new int[n][n+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return LongestInc(0,-1,nums,dp);
    }
    public int LongestInc(int idx , int prev_idx , int[] nums,int[][]dp){
        if( idx == nums.length){
             return 0;
        }
        if(dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];
        int Len = Integer.MIN_VALUE;

        int not_take = 0 + LongestInc(idx+1, prev_idx,nums,dp);
        int take = 0;
        if(prev_idx == -1) {
            take =  1 + LongestInc(idx+1, idx,nums,dp);
        }else if(nums[idx] > nums[prev_idx]){
            take =  1 + LongestInc(idx+1, idx,nums,dp);
        }

        Len = Math.max(take,not_take);
        return dp[idx][prev_idx+1] = Len;    
    }
}


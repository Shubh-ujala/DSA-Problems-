class Solution {
    public boolean predictTheWinner(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int scoreA = 0;
        int scoreB = 0;
        return solve(nums,i,j,scoreA,scoreB,true);
    }

    public boolean solve(int[]nums,int i , int j, int scoreA, int scoreB,boolean turn){
        if(i>j){
            if(scoreA >= scoreB) return true;
            return false;
        }

        if(turn){
            return solve(nums,i+1,j,scoreA+nums[i],scoreB,false) || solve(nums,i,j-1,scoreA+nums[j],scoreB,false);
        }
        return solve(nums,i+1,j,scoreA,scoreB+nums[i],true) && solve(nums,i,j-1,scoreA,scoreB+nums[j],true);
        
                
    }
}
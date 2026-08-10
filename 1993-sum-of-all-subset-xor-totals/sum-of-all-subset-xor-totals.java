class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums,0,0);
    }
    public int solve(int[] nums, int idx, int xor){

        if(idx == nums.length){
            return xor;
        }

        int include = solve(nums,idx+1,xor^nums[idx]);
        int exclude = solve(nums,idx+1,xor);

        return include+exclude;
    }
}


class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return solve(nums.length - 1, nums);
    }

    public int solve(int idx, int[] nums) {
        if (idx < 0) return 0;
        if (idx == 0) return nums[0];

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + solve(idx - 2, nums);
        int notPick = solve(idx - 1, nums);

        return dp[idx] = Math.max(pick, notPick);
    }
}
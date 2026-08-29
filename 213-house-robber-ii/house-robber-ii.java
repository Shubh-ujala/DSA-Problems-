class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        Arrays.fill(dp, -1);

        int[] arr1 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = nums[i];
        }

        int[] arr2 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr2[i - 1] = nums[i];
        }

        int ans1 = solve(arr1.length - 1, arr1);

        Arrays.fill(dp, -1);

        int ans2 = solve(arr2.length - 1, arr2);

        return Math.max(ans1, ans2);
    }

    public int solve(int idx, int[] nums) {
        if (idx == 0) return nums[idx];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + solve(idx - 2, nums);
        int notPick = solve(idx - 1, nums);

        return dp[idx] = Math.max(pick, notPick);
    }
}
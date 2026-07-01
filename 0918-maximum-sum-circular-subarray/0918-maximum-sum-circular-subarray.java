class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int currMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int x : nums) {
            total += x;

            currMax = Math.max(x, currMax + x);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(x, currMin + x);
            minSum = Math.min(minSum, currMin);
        }

        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}
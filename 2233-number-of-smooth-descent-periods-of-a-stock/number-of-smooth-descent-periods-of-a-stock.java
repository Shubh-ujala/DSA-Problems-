class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        int i = 0;
        int j = 0;

        long ans = 0;

        while (j < n) {

            if (j == 0) {
                ans++;
            }
            else if (prices[j - 1] - prices[j] == 1) {
                ans += (j - i + 1);
            }
            else {
                i = j;
                ans++;
            }

            j++;
        }

        return ans;
    }
}
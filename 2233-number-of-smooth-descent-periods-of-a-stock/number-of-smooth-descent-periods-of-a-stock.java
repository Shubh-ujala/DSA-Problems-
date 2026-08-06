class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        int i = 0;
        int j = 0;

        long ans = 0;

        while (j < n) {

            if (j > 0 && prices[j - 1] - prices[j] != 1) {
                i = j;
            }
            
            ans += (j - i + 1);
            j++;
        }

        return ans;
    }
}
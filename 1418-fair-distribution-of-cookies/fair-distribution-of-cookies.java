class Solution {

    int result = Integer.MAX_VALUE;
    int n;

    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        int[] children = new int[k];

        solve(0, cookies, children, k);

        return result;
    }

    private void solve(int idx, int[] cookies, int[] children, int k) {
        if (idx == cookies.length) {

            int max = 0;
            for (int x : children) {
                max = Math.max(max, x);
            }

            result = Math.min(result, max);
            return;
        }

        int candy = cookies[idx];

        for (int i = 0; i < k; i++) {
            children[i] += candy;

            solve(idx + 1, cookies, children, k);

            children[i] -= candy;
        }
    }
}
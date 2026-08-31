class Solution {
    List<List<Integer>> dp = new ArrayList<>(201);

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < 201; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < 201; j++) {
                row.add(Integer.MAX_VALUE);
            }

            dp.add(row);
        }
        return solve(0, 0, triangle);
    }

    public int solve(int i, int j, List<List<Integer>> triangle) {
        if (dp.get(i).get(j) != Integer.MAX_VALUE)
            return dp.get(i).get(j);
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);

        int d = triangle.get(i).get(j) + solve(i + 1, j, triangle);
        int rd = triangle.get(i).get(j) + solve(i + 1, j + 1, triangle);

        int ans = Math.min(d, rd);
        dp.get(i).set(j, ans);
        return ans;
    }
}
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int n;

    public void solve(int idx, int[] nums) {

        if (idx == n) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(nums, i, idx);

            solve(idx + 1, nums);

            swap(nums, i, idx);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        solve(0, nums);

        return result;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
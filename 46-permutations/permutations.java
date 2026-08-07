class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // without backtracking

        List<List<Integer>> res = new ArrayList<>();
        solve(nums,new ArrayList<>(),res);

        return res;
    }
    public void solve(int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(curr);
            return;
        }

        for(int num : nums){
            if(curr.contains(num)) continue;
            List<Integer> next = new ArrayList<>(curr);
            next.add(num);

            solve(nums, next, res);
        }
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        subseq(0,nums,current,res);

        return res;
    }
    public void subseq(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        // pick
        curr.add(nums[idx]);
        subseq(idx+1,nums,curr,res);
        curr.remove(curr.size() - 1);

        // not pick
        subseq(idx+1,nums,curr,res);
    }
}
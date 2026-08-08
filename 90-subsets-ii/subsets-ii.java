class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        subseq(0,nums,curr,res);

        return res;
    }
    private void subseq(int idx, int nums[] , List<Integer> curr,List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        //pick
        curr.add(nums[idx]);
        subseq(idx+1,nums,curr,res);
        curr.remove(curr.size() - 1);

        while((idx+1 <nums.length) && nums[idx] == nums[idx+1]) idx++;

        subseq(idx+1,nums,curr,res);
    }
}
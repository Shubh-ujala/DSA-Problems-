class Solution {
    List<List<Integer>> res ;
    HashSet<List<Integer>> set = new HashSet<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;

        int idx = 0;      
        solve(idx, nums);

        return res;
    }   
    public void solve(int idx, int[] nums){
        if(idx == nums.length){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int n : nums){
                arr.add(n);
            }
            if(!set.contains(arr)) {
                res.add(arr);
                set.add(arr);
            }
            return;
        }

        for(int i = idx ; i<n ; i++){
            swap(idx,i,nums);
            solve(idx+1,nums);
            swap(idx,i,nums);
        }
    }
    public void swap(int a, int b , int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
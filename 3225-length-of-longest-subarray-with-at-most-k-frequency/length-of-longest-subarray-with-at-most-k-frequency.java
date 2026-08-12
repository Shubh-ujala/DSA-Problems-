class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        int maxLen = Integer.MIN_VALUE;

        while(j<n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
    
            while(hm.get(nums[j])>k){
                int currFreq = hm.get(nums[i]);
                hm.put(nums[i],currFreq-1);
                if(hm.get(nums[i]) == 0) hm.remove(nums[i]);
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;

        }

        return maxLen;
    }
}
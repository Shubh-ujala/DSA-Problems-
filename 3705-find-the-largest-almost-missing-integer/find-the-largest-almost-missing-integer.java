class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }

        int res = 0;
        if(k == 1){
            int temp = Integer.MIN_VALUE;
            for(int key : hm.keySet()){
                if(hm.get(key) == 1 && key > temp){
                    temp = key;
                }
            }

            return temp == Integer.MIN_VALUE ? -1 : temp;
        }else if(k == n){
            int max_i = Integer.MIN_VALUE;
            for(int i : nums){
                max_i = Math.max(max_i,i);
            }

            return max_i;
        }else{
            if(hm.get(nums[0]) == 1 && hm.get(nums[n-1]) == 1){
                return Math.max(nums[0],nums[n-1]);
            }else if(hm.get(nums[0]) != 1 && hm.get(nums[n-1]) == 1){
                return nums[n-1];
            }else if(hm.get(nums[0]) == 1 && hm.get(nums[n-1]) != 1){
                return nums[0];
            }else{
                return -1;
            }
        }
    }
}
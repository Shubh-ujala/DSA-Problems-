class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = 0;
        int count = 0;

        for(int i = 0; i<nums.length ; i++){
            if(count == 0){
                ele = nums[i];
                count++;
            }else{
                if(nums[i]!= ele){
                    count--;
                }else{
                    count++;
                }
            }
        }

        int freq = 0;
        for(int i : nums){
            if(i == ele) freq++;
        }
        return freq > n/2 ? ele : -1;

    }
}
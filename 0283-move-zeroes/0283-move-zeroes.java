class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for(p2 = 0 ; p2<nums.length ; p2++){
            if(nums[p2]!=0){
                swap(p1,p2,nums);
                p1++;
            }
        }
    }
    public void swap(int p1, int p2, int []nums){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
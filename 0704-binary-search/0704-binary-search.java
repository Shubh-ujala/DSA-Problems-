class Solution {
    public int search(int[] nums, int target) {
        int sp = 0;
        int ep = nums.length - 1;
        while(sp<=ep){
            int mid = (sp+ep)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <target){
                sp = mid + 1;
            }else{
                ep = mid - 1;
            }
        }
        return -1;
    }
}
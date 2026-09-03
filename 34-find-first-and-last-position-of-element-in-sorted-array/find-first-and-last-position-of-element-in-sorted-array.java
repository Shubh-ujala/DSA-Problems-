class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int sp = 0;
        int ep = n - 1;

        int firstIdx = findFirst(sp,ep,nums,target);
        int lastIdx = findLast(sp,ep,nums,target);

        return new int[]{firstIdx, lastIdx};
    }

    public int findFirst(int sp , int ep , int[] nums, int target){
        
        int idx = -1;
        while(sp <= ep){
            int mid = (sp+ep)/2;
            if(nums[mid] == target){
                idx = mid;
                ep = mid - 1;
            }else if(nums[mid] < target){
                sp = mid+1;
            }else{
                ep = mid-1;
            }
        }

        return idx;
    }

    public int findLast(int sp , int ep , int[] nums , int target){
        int idx = -1;
        while(sp <= ep){
            int mid = (sp+ep)/2;
            if(nums[mid] == target){
                idx = mid;
                sp = mid+1;
            }else if(nums[mid] < target){
                sp = mid+1;
            }else{
                ep = mid - 1;
            }
        }

        return idx;
    }
}
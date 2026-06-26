class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int sp = 0;
        int ep = n - 1;
        int ans = -1;
        int firstIdx = searchFirst(nums,target,sp,ep,ans);
        int lastIdx = searchLast(nums,target,sp,ep,ans);

        return new int[]{firstIdx, lastIdx};

    }
    public int searchFirst(int nums[], int target, int sp, int ep,int ans){
        
        while(sp<=ep){
            int mid = (sp+ep)/2;
            if(nums[mid] == target){
                ans = mid;
                ep = mid - 1;
            }else if(nums[mid]>target){
                ep = mid - 1;
            }else{
                sp = mid + 1;
            }
        }

        return ans;
    }
    public int searchLast(int nums[], int target, int sp, int ep,int ans){
        
        while(sp<=ep){
            int mid = (sp+ep)/2;
            if(nums[mid] == target){
                ans = mid;
                sp = mid + 1;
            }else if(nums[mid]>target){
                ep = mid - 1;
            }else{
                sp = mid + 1;
            }
        }

        return ans;
    }
}
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int pref[] = new int[n];
        int suf[] = new int[n];

        pref[0] = nums[0];
        for(int i = 1 ; i<n ; i++){
            pref[i] = Math.max(pref[i-1],nums[i]);
        }

        suf[n-1] = nums[n-1];
        for(int i = n - 2; i>=0 ; i--){
            suf[i] = Math.min(suf[i+1],nums[i]);
        }

        int idx = -1;
        for(int i = 0 ; i<n ; i++){
            if(pref[i] - suf[i] <= k){
                idx = i;
                break;
            }
        }

        return idx;
    }
}
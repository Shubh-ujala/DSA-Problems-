class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closetSum = 10000000;
        int n = nums.length;
        for(int k = 0 ; k<=n - 3 ; k++){
            int i = k+1;
            int j = n-1;

            while(i < j){
                int sum = nums[k]+nums[i]+nums[j];
                if(Math.abs(target-sum) < Math.abs(target-closetSum)){
                    closetSum = sum;
                }

                if(sum<target)i++;
                else j--;
            }
        }
        return closetSum;
    }
}
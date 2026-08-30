class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = -1;
        int maxIdx = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }

            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }


        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        int option1 = right + 1;

        int option2 = n - left;

        int option3 = (left + 1) + (n - right);

        return Math.min(option1,Math.min(option2,option3));
    }
}
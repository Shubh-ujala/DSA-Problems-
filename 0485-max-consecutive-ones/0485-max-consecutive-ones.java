class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currOne = 0;
        int maxOnes = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i] == 0){
                maxOnes = Math.max(maxOnes,currOne);
                currOne = 0;
                continue;
            }
            currOne++;
        }
        return Math.max(currOne,maxOnes);
    }
}
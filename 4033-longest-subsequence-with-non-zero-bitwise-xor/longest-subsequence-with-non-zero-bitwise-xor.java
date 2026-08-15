class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int XOR = 0;
        boolean flag = true; // check for zero

        for(int i : nums){
            XOR ^= i;
            if( i != 0) flag = false;
        }

        if(flag) return 0;
        return XOR == 0 ? (n - 1) : n;
    }
}
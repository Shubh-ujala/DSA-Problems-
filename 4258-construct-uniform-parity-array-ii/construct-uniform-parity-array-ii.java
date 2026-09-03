class Solution {
    public boolean uniformArray(int[] nums1) {
        int evenCount = 0;
        int oddCount = 0;
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for(int i : nums1){
            if(i % 2 == 0) {
                minEven = Math.min(i,minEven);
                evenCount++;
            }
            else {
                minOdd = Math.min(i,minOdd);
                oddCount++;
            }
        }

        int n = nums1.length;
        if( evenCount == n || oddCount == n) return true;
        return minEven > minOdd;
    }
}
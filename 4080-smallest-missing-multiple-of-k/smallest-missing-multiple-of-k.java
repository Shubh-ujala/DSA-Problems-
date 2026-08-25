class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i : nums){
            if( i % k == 0) hs.add(i);
        }

        int val = k;
        while(hs.contains(val)){
            val+=k;
        }

        return val;
    }
}
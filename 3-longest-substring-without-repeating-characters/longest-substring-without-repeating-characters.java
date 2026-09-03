class Solution {
    public int lengthOfLongestSubstring(String s) { 
        int[] freq = new int[256];
        int i = 0;
        int j = 0;
        int maxLen = 0;

        int n = s.length();
        while(j < n){
            char ch = s.charAt(j);
            freq[ch]++;

            while(freq[ch] > 1){
                char start = s.charAt(i);
                freq[start]--;
                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
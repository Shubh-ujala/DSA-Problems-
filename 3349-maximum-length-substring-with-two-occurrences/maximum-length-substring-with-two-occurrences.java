class Solution {
    public int maximumLengthSubstring(String s) {
        // HashMap<Character,Integer> hm = new HashMap<>();
        int[] freq = new int[26];

        int i = 0;
        int j = 0;
        int n = s.length();
        int k = 2;
        int maxLen = Integer.MIN_VALUE;

        while( j < n){
            char ch = s.charAt(j);
            freq[ch -'a']++;

            while(freq[ch - 'a'] > k){
               char temp = s.charAt(i);
               
               freq[temp - 'a']--;
               if(freq[temp - 'a'] == 0) freq[temp - 'a'] = 0;

               i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
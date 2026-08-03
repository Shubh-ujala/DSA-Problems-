class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int i = 0;
        int j = 0;
        int n = s.length();
        int size = 0;
        int maxSize = 0;

        while (j < n) {
            char ch = s.charAt(j);
            freq[ch - 'a']++;
            size++;

            if (freq[ch - 'a'] <= 2) {
                maxSize = Math.max(maxSize, size);
                j++;
            } else {
                while (freq[ch - 'a'] > 2) {
                    freq[s.charAt(i) - 'a']--;
                    i++;
                    size--;
                }
                maxSize = Math.max(maxSize, size);
                j++;
            }
        }

        return maxSize;
    }
}
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int[] freq = new int[2];
        int i = 0;
        int j = 0;
        int n = s.length();
        int count = 0;
        while(j < n){
            char ch = s.charAt(j);
            int num = ch - '0';
            freq[num]++;
            while(freq[0] > k && freq[1] > k){
                char c = s.charAt(i);
                int temp = c - '0';
                freq[temp]--;
                i++;
            }
            count+= (j-i+1);
            j++;
        }

        return count;
    }
}
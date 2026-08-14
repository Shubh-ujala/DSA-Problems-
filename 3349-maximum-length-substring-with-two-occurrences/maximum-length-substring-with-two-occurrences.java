class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();

        int i = 0;
        int j = 0;
        int n = s.length();
        int k = 2;
        int maxLen = Integer.MIN_VALUE;

        while( j < n){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);

            while(hm.get(ch) > k){
               char temp = s.charAt(i);
               int freq = hm.get(temp);

               hm.put(temp,freq-1);
               if(hm.get(temp) == 0) hm.remove(temp);

               i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
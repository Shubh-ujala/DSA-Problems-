class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>(); 
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;

        int n = s.length();
        while(j < n){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);

            while(hm.get(ch) > 1){
                char start = s.charAt(i);
                int freq = hm.get(start);
                hm.put(start, freq-1);
                if(hm.get(start) == 0) hm.remove(start);

                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
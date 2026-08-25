class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        Arrays.sort(strs);
        int n = strs.length;
        String s1 = strs[0];
        String s2 = strs[n-1];

        int i = 0;
        int j = 0;
        int idx = -1;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                idx = i;
                break;
            }
            i++;
            j++;
        }

        return idx == -1 ? s1 : s1.substring(0,idx);
    }
}
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        String sortedStr = new String(ch);
        if(s.equals(sortedStr)) return 0;

        if(n == 2) return -1;
        if(s.charAt(0) == ch[0] || s.charAt(n-1) == ch[n-1]) return 1;

        if(s.charAt(0) == ch[n-1] && s.charAt(n-1) == ch[0] && ch[0]!=ch[1] && ch[n-2]!= ch[n-1]) return 3;


        return 2;
    }
}
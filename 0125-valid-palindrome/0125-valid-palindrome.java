class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();

        int sp  = 0;
        int ep = str.length() - 1;
        char[] ch = str.toCharArray();
        while(sp<=ep){
            if(ch[sp]!=ch[ep]) return false;
            sp++;
            ep--;
        }
        return true;
    }
}
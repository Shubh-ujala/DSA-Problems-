class Solution {
    public void reverseString(char[] s) {
        int sp  = 0;
        int ep = s.length - 1;
        while(sp<ep){
            char ch = s[sp];
            s[sp] = s[ep];
            s[ep] = ch;
            sp++;
            ep--;
        }
    }
}
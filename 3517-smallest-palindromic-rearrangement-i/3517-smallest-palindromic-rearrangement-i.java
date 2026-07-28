class Solution {
    public String smallestPalindrome(String s) {
        if(s.length() == 1)return s;
        int len = s.length();
        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        char[] str = new char[len];
        int k = 0;
        int j = str.length - 1;
        for(int i = 0;i<26;i++){
            while(freq[i]>=2){
                char ch = (char)(i + 'a');
                str[k] = ch;
                str[j] = ch;
                k++;
                j--;
                freq[i]-=2;
            }
           



        }
        for(int i = 0;i<26 ;i++){
            if(freq[i] == 1){
                char ch = (char)(i+'a');
                str[k] = ch;
                break;
            }
        }

        return new String(str);
                 

    }   
}
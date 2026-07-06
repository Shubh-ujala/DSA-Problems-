class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = s.length();
        int vowelCount = 0;
        while(j<n){
            if(isVowel(s.charAt(j)))vowelCount++;
            if((j-i+1)<k) j++;
            else if((j - i + 1) == k){
                ans = Math.max(vowelCount,ans);
                if(isVowel(s.charAt(i))){
                    vowelCount--;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
    public boolean isVowel(char ch){
        return ch == 'a'|| ch == 'e'|| ch == 'i' || ch=='o' || ch=='u';
    }
}
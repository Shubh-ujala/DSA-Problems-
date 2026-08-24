class Solution {
    public int vowelConsonantScore(String s) {
        int vowelCount = 0;
        int consonentCount = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)) vowelCount++;
            else if(Character.isLetter(ch)) consonentCount++;
        }

        return consonentCount == 0 ? 0 : vowelCount/consonentCount;      
    }

    public boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
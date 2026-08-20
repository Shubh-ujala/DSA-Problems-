class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char ch : word.toCharArray()){
            if(ch >=65 && ch<=90) count++;
        }

        if(count == 0 || count == word.length()) return true;
        if(count == 1 && word.length()!= 1){
            return Character.isUpperCase(word.charAt(0));
        }

        return false;
    }
}
class Solution {
    public String sortString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        Arrays.sort(ch);

        while(true){

            boolean flag = true;
            for(int i = 0 ; i<26 ; i++){
                if(freq[i] > 0){
                    char c = (char)(i + 'a');
                    sb.append(c);
                    freq[i]--;
                    flag = false;
                }
            }

            if(flag) break;

            for(int i = 25 ; i>= 0 ; i--){
                if(freq[i] > 0){
                    char c = (char)(i + 'a');
                    sb.append(c);
                    freq[i]--;
                    flag = true;
                }
            }

            if(!flag) break;
        }

        return sb.toString();
        
    }
}
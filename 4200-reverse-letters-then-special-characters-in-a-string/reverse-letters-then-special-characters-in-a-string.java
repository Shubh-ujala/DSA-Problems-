class Solution {
    public String reverseByType(String s) {
        int n = s.length();

        int i = 0;
        int j = n - 1;
        char[] ch = s.toCharArray();

        while(i < j){
            if((ch[i] >= 'a' && ch[i]<= 'z') && (ch[j] >= 'a' && ch[j] <= 'z') ){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }else if((ch[j] < 'a' || ch[j] > 'z')){
                j--;
            }else{
                i++;
            }
        }
        i = 0;
        j = n-1;
        while( i < j){
             if((ch[i]  < 'a' || ch[i] > 'z') && (ch[j]  < 'a' || ch[j] > 'z') ){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }else if((ch[j]  >= 'a' && ch[j] <= 'z')){
                j--;
            }else{
                i++;
            }
        }

        return new String(ch);
    }
}
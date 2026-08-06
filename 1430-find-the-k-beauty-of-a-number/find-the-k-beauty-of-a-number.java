class Solution {
    public int divisorSubstrings(int num, int k) {
        int i = 0;
        int j = 0;
        String str = String.valueOf(num);

        int n = str.length();
        int count = 0;

        while(j < n){
            if(j - i + 1< k)j++;
            else if(j - i + 1 == k){
                String s = str.substring(i,j+1);
                int p = Integer.parseInt(s);

                if(p!=0 && num% p == 0)count++;
                i++;
                j++;
            }
        }
        return count;
    }
}
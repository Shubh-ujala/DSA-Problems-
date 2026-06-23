class Solution {
    public int reverse(int x) {
        // int ans = 0;
        // int n = x;
        // if(x<0){
        //     n = Math.abs(x);
        // }
        // while(n>0){
        //     int p = n%10;
        //     if(ans>Integer.MAX_VALUE/10 || ans<Integer.MIN_VALUE/10)
        //     return 0;
        //     ans = ans*10 + p;
        //     n = n/10;
        // }
        // if(x<0){
        //     ans = (-1)*ans;
        // }
        // return ans;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;      // Get last digit
            x = x / 10;            // Remove last digit
            
            // Check for overflow before multiplying by 10
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            
            rev = rev * 10 + pop;
        }
        return rev;
    }
}






















        // int ans = 0;
        // int initial = x;
        // if(x<0){
        //     x = Math.abs(x);
        // }
        // while(x>0){
        //     int p = x%10;
        //     if(ans>(Integer.MAX_VALUE/10) || ans<(Integer.MIN_VALUE/10))
        //     return 0;
        //     ans = ans*10 + p;
           
        //     x = x/10;
        // }
        // if(initial<0){
        //     ans = -1*ans;
        // }
        // return ans;
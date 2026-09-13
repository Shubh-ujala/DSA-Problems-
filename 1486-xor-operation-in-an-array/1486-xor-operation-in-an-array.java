class Solution {
    public int xorOperation(int n, int start) {
        int XOR = 0;
        int i = 0;
        while(n-- > 0){
            XOR^= start+ (2*i);
            i++;
        }
        return XOR;
    }
}
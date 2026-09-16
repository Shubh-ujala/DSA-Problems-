class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;

        if( n == 2) return true;

        for(int i = 0  ; i<=n-3 ; i++){
            int[] p1 = coordinates[i];
            int[] p2 = coordinates[i+1];
            int[] p3 = coordinates[i+2];

            if(!collinear(p1[0],p1[1],p2[0],p2[1],p3[0],p3[1])) return false;
        }
        return true;
    }
    public boolean collinear(int x1,int y1, int x2, int y2, int x3, int y3){
        return (x2-x1)*(y3-y2) == (y2 - y1)*(x3-x2);
    }
}
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int sp = 1;
        int ep = n;
        int ans = 0;

        while(sp<=ep){
            int mid = sp + (ep - sp)/2;
            boolean checkBad = isBadVersion(mid);

            if(checkBad == false){
                sp = mid+1;
            }else{
                ans = mid;
                ep = mid-1;
            }
        }

        return ans;
    }
}
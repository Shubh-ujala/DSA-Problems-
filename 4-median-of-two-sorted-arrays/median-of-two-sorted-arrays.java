class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                merged[k] = nums1[i];
                k++;
                i++;
            }else if(nums2[j] < nums1[i]){
                merged[k] = nums2[j];
                k++;
                j++;
            }else{
                merged[k] = nums1[i];
                k++;
                merged[k] = nums2[j];
                k++;
                i++;
                j++;
            }
        }

        while(j<m){
            merged[k++] = nums2[j];
            j++;
        }

        while(i <n){
            merged[k++] = nums1[i];
            i++;
        }

        int len = merged.length;

        if(len%2!=0){
            return merged[len/2];
        }

        int a = len/2 - 1;
        int b = len/2;

        double ans =(double)( merged[a] + merged[b] )/2;

        return ans;

    }
}